package com.revature.services;

import com.revature.daos.CourseDAO;
import com.revature.exceptions.CourseNotFoundException;
import com.revature.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    // For update we also use the save method here
    public Course updateCourse(Course c){
        return courseDao.save(c);
    }

    // Let's look at delete course
    // Delete course should be simple enough, delete from CRUDrepo works off id so we'll pass that in

    public boolean deleteCourse(int id){
        // To delete by id, call deleteById
        courseDao.deleteById(id);

        // Since delete by id returns void, how can we check to see if it worked?
        // We'll leverage existsById
        return !(courseDao.existsById(id));
    }

    // Find by ID
    public Course findCourseById(int id){
        // This returns an optional which is a special class that allows us to work with values that may be null
        // If this exists we'll return the value, or else we'll maybe raise an exception
        return courseDao.findById(id).orElseThrow(() -> new CourseNotFoundException("No course found with id: " + id));
    }

    // Let's get all these courses
    public List<Course> getAllCourses(){
        List<Course> courses = courseDao.findAll();

        return courses;
    }

    public List<Course> searchCourses(String searchPattern){
        return courseDao.findByNameContainingIgnoreCase(searchPattern);
//        return courseDao.findByNameSearch(searchPattern);
    }
}
