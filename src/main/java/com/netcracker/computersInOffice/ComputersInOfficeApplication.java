package com.netcracker.computersInOffice;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputersInOfficeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ComputersInOfficeApplication.class, args);
		//MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
		//MongoClient mongoClient = new MongoClient(uri);
		try{
            //var mongoClient = MongoClients.create("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
			SpringApplication.run(ComputersInOfficeApplication.class, args);
            //System.setProperty("org.mongodb.async.type", "netty");
            //var mongoClient = MongoClients.create("mongodb+srv://xtended16:q19961609q@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
			MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:<paord>@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            System.out.println("Connect to database successfully");

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}

}
