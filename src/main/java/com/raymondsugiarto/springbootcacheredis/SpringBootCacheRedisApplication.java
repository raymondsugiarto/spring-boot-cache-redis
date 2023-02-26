package com.raymondsugiarto.springbootcacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringBootCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheRedisApplication.class, args);
    }

}
