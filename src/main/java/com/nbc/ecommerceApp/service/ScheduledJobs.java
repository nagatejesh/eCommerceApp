package com.nbc.ecommerceApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduledJobs {

    @Value("${feed.path}")
    private String path;
    private final ProductService service;

//    @Scheduled(fixedDelay = 5000) //run every 5 secs
    @Scheduled(cron = "*/5 * * * * *")
    public void job1(){
        long count = service.getProductCount();
        log.info("1st job Thread name::"+Thread.currentThread().getName());
        File file = new File(path);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write(String.format("Product Count @%s is :: %d", LocalDateTime.now().toString(), count));
            bw.newLine();
            bw.flush();
        }catch(Exception e){
            log.error("Encountered error in creating feed file", e);
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void job2() {
        log.info("job2 is executed");
    }

}
