package com.revature.controllers;

import com.revature.models.Course;
import com.revature.models.Person;
import com.revature.security.JwtGenerator;
import com.revature.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class PersonController {

    // We need to inject in our PersonService
    private final PersonService personService;

    private final JwtGenerator jwtGenerator;

    @Autowired
    public PersonController(PersonService personService, JwtGenerator jwtGenerator) {
        this.personService = personService;
        this.jwtGenerator = jwtGenerator;
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

    @PostMapping("courses/{cid}/register/{pid}") // http:localhost:8080/users/courses/cid/register/pid
    public ResponseEntity<?> registerForCourseHandler(@PathVariable("pid") int pid,
                                                   @PathVariable("cid") int cid,
                                                   @RequestHeader("Authorization") String bearerToken){
        // We'll revamp this method to allow the logged in user to only enroll for themselves
        // We need to get the user from the JWT
        // We added in the JWT generator and got the username from it

        // We pull this from the header information
        String username = jwtGenerator.getUsernameFromToken(bearerToken.substring(7));

        // This becomes a game of just verification
        Person p = personService.findPersonByUsername(username);

        // To verify a person is only accessing their own records the id in the path variable should match the
        // id of the person found

        if (p.getId() == pid){
            return new ResponseEntity<Person>(personService.registerForCourse(pid, cid), HttpStatus.OK);
        } else {
            // Should be a forbidden request if it made it this far
            return new ResponseEntity<String>("You cannot access another user's records!", HttpStatus.FORBIDDEN);
        }


    }

    @DeleteMapping("courses/{cid}/register/{pid}")
    public ResponseEntity<?> unregisterForCourseHandler(@PathVariable("pid") int pid, @PathVariable("cid") int cid,
                                             @RequestHeader("Authorization") String bearerToken){
        // We'll revamp this method to allow the logged in user to only enroll for themselves
        // We need to get the user from the JWT
        // We added in the JWT generator and got the username from it

        // We pull this from the header information
        String username = jwtGenerator.getUsernameFromToken(bearerToken.substring(7));

        // This becomes a game of just verification
        Person p = personService.findPersonByUsername(username);

        // To verify a person is only accessing their own records the id in the path variable should match the
        // id of the person found

        if (p.getId() == pid){
            return new ResponseEntity<Person>(personService.unregisterForCourse(pid, cid), HttpStatus.OK);
        } else {
            // Should be a forbidden request if it made it this far
            return new ResponseEntity<String>("You cannot access another user's records!", HttpStatus.FORBIDDEN);
        }
    }
}




