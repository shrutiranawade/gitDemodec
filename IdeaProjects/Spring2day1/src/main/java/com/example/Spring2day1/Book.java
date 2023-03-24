package com.example.Spring2day1;

import jakarta.persistence.*;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private int price;

    @ManyToOne
            @JoinColumn
    Author author;


    public Book() {
    }

    public Book(int bookId, String title, int price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }
}
