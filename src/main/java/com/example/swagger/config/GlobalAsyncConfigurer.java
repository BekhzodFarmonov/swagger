package com.example.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
@Configuration
@Slf4j
public class GlobalAsyncConfigurer implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
         ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(10);
            taskExecutor.setMaxPoolSize(60);
            taskExecutor.setKeepAliveSeconds(30);
            taskExecutor.setQueueCapacity(100);
            taskExecutor.setThreadNamePrefix("My Behzod's pool-");
            taskExecutor.initialize();
            return  taskExecutor;
        }
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex,method,params)->{
            log.info("Error: On Method: {},Input :Parameters: {}" ,method.getName(),params);
            ex.printStackTrace();
        };
    }
}