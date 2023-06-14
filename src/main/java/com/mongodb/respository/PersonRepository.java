package com.mongodb.respository;

import com.mongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PersonRepository")
public interface PersonRepository extends MongoRepository<Person, String> {
    Optional<List<Person>> findByFirstNameStartsWith(String firstName);

    @Query(value = "{'age' : { $gte : ?0, $lte : ?1 }}")
    Optional<List<Person>> getPersonByAgeBetween(Integer minAge, Integer maxAge);
}
