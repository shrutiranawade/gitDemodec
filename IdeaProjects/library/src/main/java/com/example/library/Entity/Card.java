package com.example.library.Entity;

import com.example.library.Enum.CardStatus;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private  Date UpdationDate;
    private String validTill;


    @OneToOne     //1 student - 1 card
    @JoinColumn   //It will introduce foreign column on the basis of
    Student student;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction>transactions = new ArrayList<>();
    //caret block removal = numlock+0 button press


}
