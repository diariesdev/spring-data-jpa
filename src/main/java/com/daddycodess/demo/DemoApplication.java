package com.daddycodess.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository studentRepository,
			StudentIdCardRepository studentIdCardRepository){
		return  args -> {
			Faker faker = new Faker();

			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s%s@gmail.com", firstName, lastName);
			Student student = new Student(
				firstName,
				lastName,
				email,
				faker.number().numberBetween(17, 55)
			);

			StudentIdCard studentIdCard = new StudentIdCard("123456789", student);

			studentIdCardRepository.save(studentIdCard);

			studentIdCardRepository.findById(1L)
					.ifPresent(System.out::println);

			studentRepository.findById(1L)
					.ifPresent(System.out::println);

			//studentRepository.deleteById(1L);

		};
	}

}
