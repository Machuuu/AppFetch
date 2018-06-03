package com.foobar.appfetch.service;

import com.foobar.appfetch.domain.Person;
import com.foobar.appfetch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public Person getPerson(Long id) {

        Optional<Person> p = repo.findById(id);

        if (p.isPresent()) {
            return p.get();
        }
        else {
            throw new NullPointerException("Can not find Person!");
        }
    }

    public Person setPerson(Person person) {
        if (person != null) {
            if (person.getName() == null || person.getName().isEmpty()) {
                throw new NullPointerException("Unable to parse name!");
            }
            return repo.save(person);
        }
        else{
            throw new NullPointerException("Person is null!");
        }
    }

    public Iterable<Person> getAllPerson() {
        return repo.findAll();
    }
}
