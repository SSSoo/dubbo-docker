package com.example.service.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guiqiang on 02/13/17.
 */
@SpringBootApplication
@ImportResource({"classpath:services.xml","classpath:applicationContext.xml"})
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}
