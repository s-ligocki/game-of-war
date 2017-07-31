package com.beleco.gameofwar.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by Everdark on 31.07.2017.
 */
@Configuration
public class BeanConfig {

    @Value("${redis-url}")
    private final String REDIS_URL = "localhost";

    @Bean
    Jedis jedis(){
        return new Jedis(REDIS_URL);
    }

}
