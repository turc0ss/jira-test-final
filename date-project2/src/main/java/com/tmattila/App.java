package com.tmattila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/***
 * Date storage application.
 * @author Tapio Mattila
 *
 */
@SpringBootApplication
@EnableMongoRepositories({"com.tmattila"})
public class App extends SpringBootServletInitializer {

	/***
	 * Main method for the application.
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
}




