package com.mongodb.service;


import com.mongodb.collection.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);

    List<Person> getPersonStartWith(String firstName);

    void deletePerson(String person_Id);

    List<Person> getPersonByAge(Integer minAge, Integer maxAge);

    Page<List<Person>> search(String firstName, Integer minAge, Integer maxAge, String city, Pageable pageable);
}
