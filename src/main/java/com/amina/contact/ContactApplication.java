package com.amina.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amina.contact.Contact;
import com.amina.contact.ContactRepository;
import com.amina.contact.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner(ContactService contactService){
		return args -> {
			contactService.ajouterContact(new Contact(
					null,
					"fatima",
					"diouck",
					"456787989",
					"thies",
					"tima@gmail.com"

			));
			contactService.ajouterContact(new Contact(
					null,
					"Saliou",
					"diouck",
					"234567989",
					"thies",
					"saliou@gmail.com"

			));
		};
	}

}

