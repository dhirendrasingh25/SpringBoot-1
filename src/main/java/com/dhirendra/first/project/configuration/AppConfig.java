package com.dhirendra.first.project.configuration;

import com.dhirendra.first.project.DB;
import com.dhirendra.first.project.DevDB;
import com.dhirendra.first.project.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name="project.mode",havingValue = "production")
    public DB getProdDBBean(){
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name="project.mode",havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }
}
