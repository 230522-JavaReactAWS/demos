package com.revature.daos;

import com.revature.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> { // Class itself and it's primary key data type

    // Hey this is cool but it doesn't have EVERY query I want
    // This will include findAll, findById, save (create and update) and delete among others
    // What if I wanted to instead get the course by name?

    Course findByName(String name);

}
