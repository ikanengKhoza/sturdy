package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name= "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
   @Id

   @SequenceGenerator(
           name = "users_sequence",
           sequenceName = "users_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "users_sequence"
   )
    private Long id;
    private String username;
    private String password;
    private String email;

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name= "users_blogs_table", joinColumns = {
           @JoinColumn(name = "users_id", referencedColumnName = "id")

   },

           inverseJoinColumns = {
                   @JoinColumn(name = "blogs_id", referencedColumnName = "id")
           }
   )
    private Set<Blogs> blogs;

}
