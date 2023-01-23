package com.in28minutes.database.databasedemo.springdata;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepo extends JpaRepository<Person, Integer> {

}
