package com.foobar.appfetch.controllers;

import com.foobar.appfetch.domain.Person;
import com.foobar.appfetch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Example {

    @Autowired
    private PersonService personService;

    /**
     * Set the person to server.
     *
     * @param person Person object
     * @return Server recognized person
     */
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public Person setPerson(@RequestBody Person person) {
        return personService.setPerson(person);
    }

    /**
     * Get the person from server.
     *
     * @return Person from server
     */
    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable(value = "id") Long id) {
        return personService.getPerson(id);
    }

    /**
     * Get all persons.
     *
     * @return all persons
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public Iterable<Person> getAllPerson() {
        return personService.getAllPerson();
    }
}
