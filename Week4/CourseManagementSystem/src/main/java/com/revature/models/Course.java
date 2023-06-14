package com.revature.models;

import javax.persistence.*;

@Entity // Marks that this class should be represented in db
@Table(name = "courses") // Allows you to alter the table
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

    public Course() {
    }

    public Course(int id, String name, String description, int credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Course(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                '}';
    }
}
