package com.dan.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@Configuration
@Profile("test-embedded")
@EnableMongoRepositories(basePackages = {"com.dan.sample" })
public class EmbeddedMongoConfig extends AbstractMongoConfiguration {

    
    @Override
    protected String getDatabaseName() {
        return "nosqlembedded";
    }

    @Override
    @Bean(name="mongo")
    public Mongo mongo() throws Exception {
        return new Fongo(getDatabaseName()).getMongo();
    }
    
}
