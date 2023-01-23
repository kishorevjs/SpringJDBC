package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepo personJpaRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10007 is {}", personJpaRepo.findById(10007));
		logger.info("Inserted row is - {}",
				personJpaRepo.insert(new Person(10010, "Micheal", "Cuba", new Date())));
		logger.info("Update id is 10003- {}",
				personJpaRepo.update(new Person(10003, "Vutukury", "India", new Date())));
		/*logger.info("All users --> {}", dao.findAll());
		logger.info("User with the location {}", dao.findByLocation("USA"));
		//logger.info("Users with date of birth {}", dao.findByBirthDate(java.sql.Date()));
		logger.info("Id deleted 10007 - no.of rows deleted {}", dao.deleteById(10007));
		*/
	}
}