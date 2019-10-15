package com.netcracker;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongodbDataSourceConfig extends AbstractMongoConfiguration {
    final Environment env;

    public MongodbDataSourceConfig(Environment env) {
        this.env = env;
    }

    @Override
    public String getDatabaseName() {
        return env.getRequiredProperty("mongo.name");
    }

    @Override
    @Bean
    public MongoClient mongoClient() {

        ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(MongoCredential.createScramSha1Credential(
                env.getRequiredProperty("mongo.username"),
                env.getRequiredProperty("mongo.name"),
                env.getRequiredProperty("mongo.password").toCharArray()
        ));
        MongoClientOptions options = new MongoClientOptions.Builder()
                .build();
        return new MongoClient(serverAddress, credentials, options);
    }
}
