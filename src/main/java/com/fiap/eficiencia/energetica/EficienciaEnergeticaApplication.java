package com.fiap.eficiencia.energetica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class EficienciaEnergeticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EficienciaEnergeticaApplication.class, args);
    }

}