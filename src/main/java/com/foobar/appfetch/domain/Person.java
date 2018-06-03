package com.foobar.appfetch.domain;
import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
