package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "blogs")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Blogs {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String title;
    private String author;
    private String text;
    LocalDate postedOn = LocalDate.now();

}
