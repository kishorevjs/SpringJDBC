package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person table and return all the content
    public List<Person> findAll(){
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person getById(int id){
        return jdbcTemplate.queryForObject("select * from PERSON where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findByLocation(String location){
        return jdbcTemplate.query("select * from person where location=?", new Object[]{location},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findByBirthDate(Date date){
        return jdbcTemplate.query("select * from person where birth_date=?", new Object[]{date},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?, ?, ?, ?);",
                new Object[]{
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())
        });
    }

    public int update(Person person){
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id = ?",
                new Object[]{
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())
        });
    }
}
