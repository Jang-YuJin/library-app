package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected Book() {}

    public Book(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("잘못된 name " + name + "이 들어왔습니다.");
        }

        this.name = name;
    }
}
