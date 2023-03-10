package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users --> {}", dao.findAll());
		logger.info("User id 10001 is {}", dao.getById(10001));
		logger.info("User with the location {}", dao.findByLocation("USA"));
		//logger.info("Users with date of birth {}", dao.findByBirthDate(java.sql.Date()));
		logger.info("Id deleted 10007 - no.of rows deleted {}", dao.deleteById(10007));
		logger.info("Inserted row is - {}",
				dao.insert(new Person(10010, "Micheal", "Cuba", new Date())));
		logger.info("Update id is 10003- {}",
				dao.update(new Person(10003, "Vutukury", "India", new Date())));
	}
}
