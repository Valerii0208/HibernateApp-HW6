package com.example.hw_6_hibernate;

import com.example.hw_6_hibernate.AppMenu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw6HibernateApplication implements CommandLineRunner {
    @Autowired
    private Menu menu;

    public static void main(String[] args) {
        SpringApplication.run(Hw6HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.runApp();
    }
}
