package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepo {

    //connect to db
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return  entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }
}