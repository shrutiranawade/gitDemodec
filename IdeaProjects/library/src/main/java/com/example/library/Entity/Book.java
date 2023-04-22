package com.example.library.Entity;

import com.example.library.Enum.Genre;
import jakarta.persistence.*;

import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;
    @Enumerated(EnumType.STRING)
    Genre genre;
    private  boolean isIssued;
    private int noOfPages;
    @ManyToOne
    Author author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
    @ManyToOne
    Card card;
}
