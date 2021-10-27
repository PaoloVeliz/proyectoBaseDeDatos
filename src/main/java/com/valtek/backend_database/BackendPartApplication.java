package com.valtek.backend_database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BackendPartApplication implements CommandLineRunner {

	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BackendPartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
