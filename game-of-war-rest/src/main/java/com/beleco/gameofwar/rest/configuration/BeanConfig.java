package com.beleco.gameofwar.rest.configuration;

import com.beleco.gameofwar.core.login.LoginUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Everdark on 19.08.2017.
 */
@Configuration
public class BeanConfig {

    @Bean
    LoginUtil loginUtil(){
        return new LoginUtil();
    }
}
