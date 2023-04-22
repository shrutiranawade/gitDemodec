package com.example.library.Entity;

import com.example.library.Enum.Department;
import jakarta.persistence.*;

import jakarta.persistence.Id;

import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    Department department;
    @Column(unique = true)
    private String email;
    private String mobNo;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Card card;
}
