package com.revature.controllers;

import com.revature.models.Course;
import com.revature.models.Person;
import com.revature.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class PersonController {

    // We need to inject in our PersonService
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Get All
    @GetMapping
    public List<Person> getAllPeopleHandler(){
        return personService.getAllPeople();
    }

    // Get One
    @GetMapping("{id}") // /users/id
    public Person getPersonByIdHandler(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }

    // Insert
    // We pass in the person as the body of the post request
    @PostMapping
    public Person createPersonHandler(@RequestBody Person p){
        return personService.createPerson(p);
    }

    // Update
    @PutMapping
    public Person updatePersonHandler(@RequestBody Person p){
        return personService.updatePerson(p);
    }

    // Delete
    @DeleteMapping("{id}")
    public boolean deletePersonHandler(@PathVariable("id") int id){
        return personService.deletePersonById(id);
    }


    // Let's add in some methods to mess around with our new functionality
    @GetMapping("{id}/courses")
    public List<Course> getCoursesFromPersonHandler(@PathVariable("id") int id){
        return personService.getCoursesByPersonId(id);
    }

    @PostMapping("{pid}/courses/register/{cid}")
    public Person registerForCourseHandler(@PathVariable("pid") int pid, @PathVariable("cid") int cid){
        return personService.registerForCourse(pid, cid);
    }

    @DeleteMapping("{pid}/courses/register/{cid}")
    public Person unregisterForCourseHandler(@PathVariable("pid") int pid, @PathVariable("cid") int cid){
        return personService.unregisterForCourse(pid, cid);
    }
}
