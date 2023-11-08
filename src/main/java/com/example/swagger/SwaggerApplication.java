package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
@SpringBootApplication
@EnableAsync
public class SwaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
//	@Bean
//	@Profile("dev")
//	public TaskExecutor taskExecutorDev(){
//		ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
//		taskExecutor.setCorePoolSize(2);
//		taskExecutor.setMaxPoolSize(10);
//		taskExecutor.setKeepAliveSeconds(10);
//		taskExecutor.setQueueCapacity(20);
//		taskExecutor.setThreadNamePrefix("dev-");
//		taskExecutor.initialize();
//		return  taskExecutor;
//	}
//	@Bean
//	@Profile("test")
//	public TaskExecutor taskExecutorTest(){
//		ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
//		taskExecutor.setCorePoolSize(2);
//		taskExecutor.setMaxPoolSize(5);
//		taskExecutor.setKeepAliveSeconds(15);
//		taskExecutor.setQueueCapacity(40);
//		taskExecutor.setThreadNamePrefix("test-");
//		taskExecutor.initialize();
//		return  taskExecutor;
//	}
//	@Bean
//	@Profile("prod")
//	public TaskExecutor taskExecutorProd(){
//		ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
//		taskExecutor.setCorePoolSize(20);
//		taskExecutor.setMaxPoolSize(100);
//		taskExecutor.setKeepAliveSeconds(60);
//		taskExecutor.setQueueCapacity(500);
//		taskExecutor.setThreadNamePrefix("prod-");
//		taskExecutor.initialize();
//		return  taskExecutor;
//	}

}
