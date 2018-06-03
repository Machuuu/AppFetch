package com.foobar.appfetch.controllers;

import com.foobar.appfetch.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Example {

    private Person person = new Person();

    /**
     * Set the person to server.
     *
     * @param person Person object
     * @return Server recognized person
     */
    @RequestMapping(value = "/set", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Person> setPerson(@RequestBody Person person) {
        this.person = person;

        return new ResponseEntity<>(this.person, HttpStatus.OK);
    }

    /**
     * Get the person from server.
     *
     * @return Person from server
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson() {
        return new ResponseEntity<>(this.person, HttpStatus.OK);
    }

    /**
     * Search if name equals name from server's record.
     *
     * @param name name query
     * @return Person object from server if correct, BAD_REQUEST if not
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Person> searchPerson(@RequestParam(value = "name") String name) {
        if (this.person.getName().equalsIgnoreCase(name)) {
            return new ResponseEntity<>(this.person, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
