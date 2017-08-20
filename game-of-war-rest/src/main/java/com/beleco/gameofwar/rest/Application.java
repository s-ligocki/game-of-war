package com.beleco.gameofwar.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Everdark on 13.06.2017.
 */
@SpringBootApplication
@ComponentScan({"com.beleco.gameofwar"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}