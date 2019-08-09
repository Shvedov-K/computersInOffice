package com.netcracker.computersInOffice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories({"com.netcracker.repositories.interfaces"})
//@SpringBootApplication
@ComponentScan(basePackages = "com.netcracker")
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ComputersInOfficeApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
        //MongoClientOptions option	= MongoClientOptions.builder().sslEnabled(true).sslInvalidHostNameAllowed(true).build();
        //MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/Office?retryWrites=true&w=majority");
        //MongoClient mongoClient = new MongoClient(uri);
		try{
            //MongoClientURI uri = new MongoClientURI("mongodb://xtended16:q19961609q@localhost/records");
            //MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/Office?retryWrites=true&w=majority");
            //MongoClient mongoClient = new MongoClient(uri);
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
        SpringApplication.run(ComputersInOfficeApplication.class, args);
	}

	@Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {

        return applicationBuilder.sources(ComputersInOfficeApplication.class);
    }

}
