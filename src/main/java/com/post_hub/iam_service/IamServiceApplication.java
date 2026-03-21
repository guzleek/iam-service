package com.post_hub.iam_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.flywaydb.core.Flyway;

@SpringBootApplication
public class IamServiceApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(IamServiceApplication.class);
		app.run(args);

		// Ручной запуск Flyway для дебага
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:postgresql://localhost:5432/post_hub_local", "postgres", "secret123")
				.schemas("v1_iam_service")
				.locations("classpath:db/migration")
				.load();

		flyway.migrate(); // Применяет миграции вручную
	}
}