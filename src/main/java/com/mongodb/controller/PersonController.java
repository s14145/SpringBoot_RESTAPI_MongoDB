package com.mongodb.controller;


import com.mongodb.collection.Person;
import com.mongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person){
       Person savedPerson = personService.save(person);
       return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonStartWith(@RequestParam("firstName") String firstName){
        List<Person> personList = personService.getPersonStartWith(firstName);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @DeleteMapping("/{person_Id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String person_Id){
        personService.deletePerson(person_Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ages")
    public ResponseEntity<List<Person>> getByPersonAge(@RequestParam(value = "minAge", required = true) Integer minAge, @RequestParam(value = "maxAge", required = true) Integer maxAge){
        List<Person> listOfPersonByAge = personService.getPersonByAge(minAge, maxAge);
        return new ResponseEntity<>(listOfPersonByAge, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<List<Person>>> searchPerson(@RequestParam(value = "firstName", required = false) String firstName,
                                                     @RequestParam(value = "minAge", required = false) Integer minAge,
                                                     @RequestParam(value = "maxAge", required = false) Integer maxAge,
                                                     @RequestParam(value = "city", required = false) String city,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size", defaultValue = "5") Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<List<Person>> searchedPersonList = personService.search(firstName, minAge, maxAge, city, pageable);
        return new ResponseEntity<>(searchedPersonList, HttpStatus.OK);
    }
}