package com.test.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.test.jpa.repository.EmployeeDao;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = EmployeeDao.class)
public class BootDemoApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }
}