package com.auticuro.server.query;

import com.auticuro.core.entity.BalanceChangeEvent;
import com.auticuro.core.mapper.BalanceChangeEventMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@Component
public class EventConsumer {
    private final BalanceChangeEventMapper eventMapper;
    private final MaterializedViewUpdater viewUpdater;
    private final ConcurrentLinkedQueue<BalanceChangeEvent> eventQueue;
    private LocalDateTime lastProcessedEventTime = LocalDateTime.now().minusMinutes(5);

    @Autowired
    public EventConsumer(BalanceChangeEventMapper eventMapper, MaterializedViewUpdater viewUpdater) {
        this.eventMapper = eventMapper;
        this.viewUpdater = viewUpdater;
        this.eventQueue = new ConcurrentLinkedQueue<>();
    }

    @Scheduled(fixedDelay = 1000) // Process events every second
    public void consumeEvents() {
        try {
            // Fetch new events
            QueryWrapper<BalanceChangeEvent> wrapper = new QueryWrapper<>();
            wrapper.gt("event_time", lastProcessedEventTime)
                  .orderByAsc("event_time", "id")
                  .last("LIMIT 1000"); // Process in batches

            List<BalanceChangeEvent> events = eventMapper.selectList(wrapper);
            if (!events.isEmpty()) {
                events.forEach(event -> {
                    eventQueue.offer(event);
                    lastProcessedEventTime = event.getEventTime();
                });
            }

            // Process queued events
            while (!eventQueue.isEmpty()) {
                BalanceChangeEvent event = eventQueue.poll();
                try {
                    viewUpdater.processEvent(event);
                } catch (Exception e) {
                    log.error("Error processing event: {}", event, e);
                    // Re-queue the event for retry
                    eventQueue.offer(event);
                }
            }
        } catch (Exception e) {
            log.error("Error in event consumer", e);
        }
    }
}
