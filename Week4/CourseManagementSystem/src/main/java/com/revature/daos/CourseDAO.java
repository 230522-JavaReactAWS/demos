package com.revature.daos;

import com.revature.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> { // Class itself and it's primary key data type

    // Hey this is cool but it doesn't have EVERY query I want
    // This will include findAll, findById, save (create and update) and delete among others
    // What if I wanted to instead get the course by name?

    Course findByName(String name);

    // Search query
    // Select * from course where name ilike pattern
    List<Course> findByNameContainingIgnoreCase(String pattern);

    // We can actually rewrite this query by using either Native SQL or JPQL
    // @Query allows us to write the actual query itself and can be used for more complex operations
    @Query("FROM Course WHERE name LIKE %:pattern% ") // JPQL not Native SQL
    List<Course> findByNameSearch(@Param("pattern") String pattern);


}
