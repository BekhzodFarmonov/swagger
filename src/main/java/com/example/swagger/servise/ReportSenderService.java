package com.example.swagger.servise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Service
@Slf4j
public class ReportSenderService {
   // ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    @Async
    public void sendReport(){
        try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ignored){}
            log.info("report send");
        new RuntimeException("runtime exception"+ LocalDate.now());
//        bu birinchi usuli yangi threadda run qilishning
        //executorService.submit(runnable);
//        bu ikkinchi usuli
//        CompletableFuture.runAsync(runnable);
    }
}
