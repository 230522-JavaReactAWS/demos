package com.revature.services;

import com.revature.daos.CourseDAO;
import com.revature.daos.PersonDAO;
import com.revature.exceptions.CourseNotFoundException;
import com.revature.exceptions.PersonNotFoundException;
import com.revature.models.Course;
import com.revature.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    // First thing we need to do is inject in our teacher dao

    private final PersonDAO personDao;
    private final CourseDAO courseDao;

    // I'll create a logger for this class, since this isn't really a bean that needs to be wired in I can do it
    // manually
//    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired // We wired in
    public PersonService(PersonDAO personDao, CourseDAO courseDao) {
        this.personDao = personDao;
        this.courseDao = courseDao;
    }


    // We can now start creating all of our service methods

    // Create
    public Person createPerson(Person t){
        // Now let's call the DAO methods to actually create the teacher
        Person returnedPerson = personDao.save(t);

        // If successful we should have a positive Id
        if (returnedPerson.getId() > 0){
            // TODO create a log for success
            log.info("person created");
        } else{
            // TODO create a log for failure
            log.warn("Failed to create person");
        }

        return returnedPerson;
    }

    // Read All
    public List<Person> getAllPeople(){
        return personDao.findAll();
    }

    // Read One
    public Person getPersonById(int id){
        // We'll use the optional methods to return the proper thing
        return personDao.findById(id).orElseThrow(() -> new PersonNotFoundException("No person found with id: " + id));
    }

    public Person findPersonByUsername(String username){
        return personDao.findByUsername(username)
                .orElseThrow(() -> new PersonNotFoundException("No person found with username: " + username));
    }


    // Update
    public Person updatePerson(Person t){
        return personDao.save(t);
    }

    // Delete
    public boolean deletePersonById(int id){
        // We need to delete by id then verify nonexistence
        personDao.deleteById(id);

        // We need to check to see if the teacher is still in the db
        if (!personDao.existsById(id)){
            // Successful message
            return true;
        } else{
            return false;
        }
    }


    // We're going to provide new service class methods for the following

    // Get all courses registered to a person
    public List<Course> getCoursesByPersonId(int id){
        // First thing we should do is get the person from the db

        Optional<Person> returnedPerson = personDao.findById(id);

        if (returnedPerson.isPresent()){
            return returnedPerson.get().getCourses();
        } else{
            throw new PersonNotFoundException("No Person with id: " + id);
        }
    }

    // Register/Enroll in a course
    public Person registerForCourse(int pid, int cid){
        Person p = getPersonById(pid);

        // Now we need to extract the courses to add to it as necessary
        List<Course> courses = p.getCourses();

        // Now we need to search the courses table to find the course with id = cid
        Optional<Course> returnedCourse = courseDao.findById(cid);

        if (returnedCourse.isPresent()){
            if (!courses.contains(returnedCourse.get())){
                // The course exists and is NOT registered
                courses.add(returnedCourse.get());
                // We need to attach this back to the person before we call the methods to save the person
                p.setCourses(courses);

                // Save the person to the db which *should*  have the new course made
                personDao.save(p);

            }
        } else{
            throw new CourseNotFoundException("No Course with id: " + cid);
        }

        return p;
    }

    // Unregister/Un-enroll from a course
    public Person unregisterForCourse(int pid, int cid){
        Person p = getPersonById(pid);

        // Now we need to extract the courses to add to it as necessary
        List<Course> courses = p.getCourses();

        // Now we need to search the courses table to find the course with id = cid
        Optional<Course> returnedCourse = courseDao.findById(cid);

        // We need to check that the course they're attempting to unregister from both exists and is in their
        // list of courses
        if (returnedCourse.isPresent() && courses.contains(returnedCourse.get())){
            courses.remove(returnedCourse.get());
            p.setCourses(courses);
            personDao.save(p);
        } else{
            throw new CourseNotFoundException("No Course with id: " + cid);
        }

        return p;
    }

}
