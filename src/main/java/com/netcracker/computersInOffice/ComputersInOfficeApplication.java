package com.netcracker.computersInOffice;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.netcracker.repositories.implementations.IRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(repositoryBaseClass = IRepositoryImpl.class)
@SpringBootApplication
@ComponentScan(basePackages = "com.netcracker")
public class ComputersInOfficeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(ComputersInOfficeApplication.class, args);
		try{
			MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
			MongoClient mongoClient = new MongoClient(uri);
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}


	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ComputersInOfficeApplication.class);
	}
}
