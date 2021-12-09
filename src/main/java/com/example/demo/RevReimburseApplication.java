package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {
//		"com.example.demo.dao",
//		"com.example.demo.controller",
//		"com.example.demo.service"
//
//}) //Added quick fix, but why did I need this?
@SpringBootApplication
public class RevReimburseApplication {

	public static void main(String[] args) {
		System.out.println("in");
		SpringApplication.run(RevReimburseApplication.class, args);
		System.out.println("You may access this Web App by going to the following link: http://localhost:7777");

	}

}
