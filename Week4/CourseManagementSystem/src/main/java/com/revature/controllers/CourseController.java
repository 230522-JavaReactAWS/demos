package com.revature.controllers;

import com.revature.models.Course;
import com.revature.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // How do we get one like we did before? Before we would go to http://localhost:8080/courses/id

    @GetMapping("{id}")
    public Course findCourseByIdHandler(@PathVariable("id") int id){
        return courseService.findCourseById(id);
    }

    @PostMapping
    public Course createCourseHandler(@RequestBody Course c){ // @RequestBody attempts to turn the body into Java object
        return courseService.addCourse(c);
    }



}
