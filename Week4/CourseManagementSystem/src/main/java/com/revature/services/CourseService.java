package com.revature.services;

import com.revature.daos.CourseDAO;
import com.revature.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    // We need to get our DAO layer into this service layer so we'll use constructor dependency injection

    private final CourseDAO courseDao;

    @Autowired // Spring manages wiring in our DAO layer so we're good to go!
    public CourseService(CourseDAO courseDAO) {
        this.courseDao = courseDAO;
    }

    // We have a couple of methods we want to create!

    // Let's start with insert!
    public Course addCourse(Course course){

        // How do we add the course to the db?
        // We use the .save method
        Course returnedCourse = courseDao.save(course);
        // Before when we sent in the course it shouldn't have an id or it could have an id of 0
        // But when it comes OUT of the db it shouldn't be 0 or non-existent it should a positive int

        // This is something we can check for
        if (returnedCourse.getId() > 0){
            // Successful
            // TODO put success log
        } else{
            // This was a failure to add the course
            // TODO put warning log
        }

        return returnedCourse;

    }
}
