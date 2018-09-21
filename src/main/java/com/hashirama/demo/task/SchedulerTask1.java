package com.hashirama.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask1 {
    private Logger logger = LoggerFactory.getLogger(SchedulerTask1.class);
    private int count = 1;

    @Scheduled(cron="*/10 * * * * ?")
    private void process(){
        logger.info("This scheduler task is running: {},", count++);
    }

}
