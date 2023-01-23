package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepo;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataJPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonSpringDataRepo personSpringDataRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10007 is {}", personSpringDataRepo.findById(10007));
		logger.info("Inserted row is - {}",
				personSpringDataRepo.save(new Person(10010, "Micheal", "Cuba", new Date())));
		logger.info("Update id is 10003- {}",
				personSpringDataRepo.save(new Person(10003, "Vutukury", "India", new Date())));
		personSpringDataRepo.deleteById(10003);
		logger.info("All users --> {}", personSpringDataRepo.findAll());

	}
}