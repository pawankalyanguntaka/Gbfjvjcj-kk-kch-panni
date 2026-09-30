package com.hallease.api.config;

import com.hallease.api.model.Hall;
import com.hallease.api.repo.HallRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seed(HallRepository repo){
        return args -> {
            if(repo.count()==0){
                repo.save(new Hall("Royal Grand Hall","City Center",800,45000));
                repo.save(new Hall("Pearl Function Hall","Main Road",500,32000));
                repo.save(new Hall("Garden Celebration Hall","Garden Avenue",600,38000));
                repo.save(new Hall("Crystal Palace Hall","Near Highway",1000,55000));
                repo.save(new Hall("Grand Convention Hall","Convention Road",1200,65000));
            }
        };
    }
}