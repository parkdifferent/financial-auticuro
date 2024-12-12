package com.auticuro.server.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class WalletMetrics {
    private final Counter transferSuccessCounter;
    private final Counter transferFailureCounter;
    private final Counter accountCreationCounter;
    private final Timer transferLatencyTimer;
    private final Timer accountOperationTimer;

    public WalletMetrics(MeterRegistry registry) {
        this.transferSuccessCounter = Counter.builder("wallet.transfer.success")
            .description("Number of successful transfers")
            .register(registry);

        this.transferFailureCounter = Counter.builder("wallet.transfer.failure")
            .description("Number of failed transfers")
            .register(registry);

        this.accountCreationCounter = Counter.builder("wallet.account.creation")
            .description("Number of accounts created")
            .register(registry);

        this.transferLatencyTimer = Timer.builder("wallet.transfer.latency")
            .description("Transfer operation latency")
            .publishPercentiles(0.5, 0.95, 0.99)
            .register(registry);

        this.accountOperationTimer = Timer.builder("wallet.account.operation.latency")
            .description("Account operation latency")
            .publishPercentiles(0.5, 0.95, 0.99)
            .register(registry);
    }

    public void recordTransferSuccess() {
        transferSuccessCounter.increment();
    }

    public void recordTransferFailure() {
        transferFailureCounter.increment();
    }

    public void recordAccountCreation() {
        accountCreationCounter.increment();
    }

    public void recordTransferLatency(long milliseconds) {
        transferLatencyTimer.record(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void recordAccountOperationLatency(long milliseconds) {
        accountOperationTimer.record(milliseconds, TimeUnit.MILLISECONDS);
    }

    public Timer.Sample startTransferTimer() {
        return Timer.start();
    }

    public void stopTransferTimer(Timer.Sample sample) {
        sample.stop(transferLatencyTimer);
    }

    public Timer.Sample startAccountOperationTimer() {
        return Timer.start();
    }

    public void stopAccountOperationTimer(Timer.Sample sample) {
        sample.stop(accountOperationTimer);
    }
}
