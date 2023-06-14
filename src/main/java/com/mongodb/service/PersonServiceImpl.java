package com.mongodb.service;

import com.mongodb.collection.Person;
import com.mongodb.exception.PersonNotFoundException;
import com.mongodb.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("PersonServiceImpl")
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Person save(Person person) {
        if(Objects.isNull(person)){
            throw new IllegalArgumentException("Person object cannot be null. Please provide valid input.");
        }
        Person savePerson = personRepository.save(person);
        return savePerson;
    }

    @Override
    public List<Person> getPersonStartWith(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("FirstName cannot be null. Please provide valid firstname.");
        }
        Optional<List<Person>> personList = personRepository.findByFirstNameStartsWith(firstName);
        if(!personList.isPresent()){
            throw new PersonNotFoundException("Person with first name " + firstName  + " doesn't exist.");
        }
        List<Person> personListDB = personList.get();
        return personListDB;
    }

    @Override
    public void deletePerson(String person_Id) {
        Optional<Person> personFromDB = personRepository.findById(person_Id);
        if(!personFromDB.isPresent()){
            throw new PersonNotFoundException("Person with id " + person_Id  + " doesn't exist.");
        }
        Person person = personFromDB.get();
        personRepository.deleteById(person.getPerson_Id());
    }

    @Override
    public List<Person> getPersonByAge(Integer minAge, Integer maxAge) {
        Optional<List<Person>> personByAgeBetween = personRepository.getPersonByAgeBetween(minAge, maxAge);
        if(!personByAgeBetween.isPresent()){
            throw new PersonNotFoundException("No person with age between " + minAge + " and " + maxAge + " exist.");
        }
       List<Person> personList =  personByAgeBetween.get();
        return personList;
    }

    @Override
    public Page<List<Person>> search(String firstName, Integer minAge, Integer maxAge, String city, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();
        if(firstName != null && !firstName.isBlank()){
            criteria.add(Criteria.where("firstName").regex(firstName, "i"));
        }
        if(minAge != null && maxAge != null){
            criteria.add(Criteria.where("age").gte(minAge).lte(maxAge));
        }
        if(city != null && !city.isBlank()){
            criteria.add(Criteria.where("addressList.city").is(city));
        }

        // Converting list of criteria to array
        if(!criteria.isEmpty()){
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        Page<List<Person>> people = PageableExecutionUtils.getPage(
                Collections.singletonList(mongoTemplate.find(query, Person.class)), pageable, () -> mongoTemplate.count(query.skip(0).limit(0), Person.class));

        return people;
    }


}
