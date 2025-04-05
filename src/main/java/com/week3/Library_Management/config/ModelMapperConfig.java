package com.week3.Library_Management.config;

import com.week3.Library_Management.auth.AuditorAwareImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImplementation")
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper(){return new ModelMapper();}

    @Bean
    AuditorAware getAuditorAwareImplementation(){
        return new AuditorAwareImplementation();
    }
}
