package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // Marks that this class should be represented in db
@Table(name = "courses") // Allows you to alter the table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    // We started with our basic pojo (plain old java object) Now we need to tell Spring Data how to interact with it

    // We want to mark this id field as the primary key so we'll use @Id
    @Id
    @Column(name = "course_id") // allows you to alter the column
    @GeneratedValue(strategy = GenerationType.IDENTITY)// We want this to be a serial field so let's make it one
    private int id;

    @Column(unique = true) // Marks that the column needs to be unique
    private String name;

    private String description;

    private int credits;


}
