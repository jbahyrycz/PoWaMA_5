package com.example.demo.group;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClassTeacherConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(ClassTeacherRepository repository)
    {
        return args -> {
            ClassTeacher a = new ClassTeacher("Mathematicians", 3, null, null);
            ClassTeacher b = new ClassTeacher("Chemists", 3, null, null);
            repository.saveAll(List.of(a, b));
        };
    }*/
}
