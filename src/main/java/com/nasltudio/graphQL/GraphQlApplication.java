package com.nasltudio.graphQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nasltudio.graphQL.queryresolvers")
public class GraphQlApplication {


	public static void main(String[] args) {


		SpringApplication.run(GraphQlApplication.class, args);
	}

}
