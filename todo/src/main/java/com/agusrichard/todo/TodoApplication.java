package com.agusrichard.todo;

import com.agusrichard.todo.account.Account;
import com.agusrichard.todo.account.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialize(AccountRepository accountRepository) {
		return args -> {
			Account one = new Account(
					"user1@example.com",
					"User 1",
					LocalDate.now()
			);

			Account two = new Account(
					"user2@example.com",
					"User 2",
					LocalDate.now()
			);

			Account three = new Account(
					"user3@example.com",
					"User 3",
					LocalDate.now()
			);

			accountRepository.save(one);
			accountRepository.save(two);
			accountRepository.save(three);
		};
	}
}
