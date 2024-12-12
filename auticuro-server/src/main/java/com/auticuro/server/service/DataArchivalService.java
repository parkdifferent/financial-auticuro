package com.auticuro.server.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataArchivalService {

    // This method will be executed periodically
    @Scheduled(cron = "0 0 0 * * ?")  // Every day at midnight
    public void archiveData() {
        // Implement the logic to archive data here
        System.out.println("Archiving data...");
        // Example: Move old records to an archive table or compress them
    }
}
