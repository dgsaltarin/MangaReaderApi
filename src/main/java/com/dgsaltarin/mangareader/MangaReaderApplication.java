package com.dgsaltarin.mangareader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
public class MangaReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangaReaderApplication.class, args);
    }

}
