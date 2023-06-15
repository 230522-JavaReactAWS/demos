package com.revature.controllers;

import com.revature.models.Course;
import com.revature.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Marks this class as a controller and says any returned objects will be converted to json
@RequestMapping("courses") // This basically declares our general route so every path is under http://localhost:8080/courses
public class CourseController {
    // Build out our controller from previous projects but now using spring

    // We need our CourseService so let's get that
    private final CourseService courseService;

    @Autowired // Tells spring to automatically wire in the courseServiceBean to this controller
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //To declare a method that will be a handler for a specific http verb we use @VERBMapping to annotate the method
    @GetMapping
    public List<Course> getAllCoursesHandler(){
        return courseService.getAllCourses();
    }


}
