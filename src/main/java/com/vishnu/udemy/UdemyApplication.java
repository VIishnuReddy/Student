package com.vishnu.udemy;

import com.vishnu.udemy.DAO.StudentDAO;
import com.vishnu.udemy.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class UdemyApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdemyApplication.class, args);
    }


}
