package com.ampada.tracku;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan(basePackages = { "com.ampada.tracku" })
@EntityScan(basePackages = { "com.ampada.tracku" })
@EnableMongoRepositories
public class TrackuBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrackuBootApplication.class, args);
	}

}
