package com.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;

@SpringBootApplication(exclude = { Neo4jDataAutoConfiguration.class })
public class SpringDataNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jApplication.class, args);
	}

}
