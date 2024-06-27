package com.bancosystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.seu.pacote.base")
public class BancoSystemkApplication {
	public static void main(String[] args) {
		SpringApplication.run(BancoSystemkApplication.class, args);
	}
}

