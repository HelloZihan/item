package com.bjtu.item;

import com.bjtu.item.db.EnableSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSessionFactory
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
