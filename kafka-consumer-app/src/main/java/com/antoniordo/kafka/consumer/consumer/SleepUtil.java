package com.antoniordo.kafka.consumer.consumer;

public class SleepUtil {
    
    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
}
