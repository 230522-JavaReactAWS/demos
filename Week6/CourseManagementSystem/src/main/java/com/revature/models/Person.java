package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    // We need to declare our fields for Teacher
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    @Length(min = 2, max = 20)
    private String firstName;

    @Column(name="last_name")
    @Length(min = 2)
    private String lastName;

    // We'll double back to department
//    private Department department;
    // We're scrapping the original field department and doing Roles instead
    // We need to add in our Roles object
    // Many people can have one role (i.e. multiple students or multiple teachers)
    @ManyToOne
    private Role role;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany
    private List<Course> courses; // We need to tell spring there's a many to many relationship here

    // Now time for the boilerplate stuff

/*
    public Person() {
    }



    public Person(int id, String firstName, String lastName, Role role, String username, String password, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.username = username;
        this.password = password;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }


 */
}
