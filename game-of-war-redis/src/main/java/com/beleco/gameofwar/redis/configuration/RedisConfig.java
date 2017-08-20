package com.beleco.gameofwar.redis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import redis.clients.jedis.Jedis;

/**
 * Created by Everdark on 31.07.2017.
 */
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Value("${redis-url}")
    private final String REDIS_URL = "localhost";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    Jedis jedis(){
        return new Jedis(REDIS_URL);
    }

}
