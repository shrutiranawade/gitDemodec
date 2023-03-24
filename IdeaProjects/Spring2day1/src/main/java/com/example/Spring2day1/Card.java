package com.example.Spring2day1;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    @Column(nullable = false,unique = true)
    private String dob;
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;
    @OneToOne
    @JoinColumn
    User user;

    public Card() {
    }

    public Card(int cardNo, String dob, CardStatus cardStatus) {
        this.cardNo = cardNo;
        this.dob = dob;
        this.cardStatus = cardStatus;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
