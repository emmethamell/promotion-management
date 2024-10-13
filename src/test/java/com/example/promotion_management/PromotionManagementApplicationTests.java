package com.example.promotion_management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootTest
public class PromotionManagementApplicationTests {

	@DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        Dotenv dotenv = Dotenv.configure().load();
        registry.add("spring.datasource.url", () -> dotenv.get("DB_URL"));
        registry.add("spring.datasource.username", () -> dotenv.get("DB_USERNAME"));
        registry.add("spring.datasource.password", () -> dotenv.get("DB_PASSWORD"));
    }

	@Test
	void contextLoads() {
	}

}
