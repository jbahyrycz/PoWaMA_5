package com.example.demo.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(TeacherRepository repository)
    {
        return args -> {
            Teacher a = new Teacher("Julia", "Bahyrycz", 7000.0, 2003, "present");
            Teacher b = new Teacher("Jan", "Kowalski", 8500.0, 1996, "present");
            Teacher c = new Teacher("Adam", "Nowak", 6400.0, 1998, "sick");
            Teacher d = new Teacher("Anna", "Rabarbar", 7000.0, 1997, "absent");
            repository.saveAll(List.of(a, b, c, d));
        };
    }*/
}
