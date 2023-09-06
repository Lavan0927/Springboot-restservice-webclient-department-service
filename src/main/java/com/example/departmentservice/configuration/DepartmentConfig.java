package com.example.departmentservice.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfig {

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }
}
