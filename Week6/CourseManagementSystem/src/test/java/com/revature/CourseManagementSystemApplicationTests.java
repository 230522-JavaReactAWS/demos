package com.revature;


import com.revature.daos.CourseDAO;
import com.revature.daos.PersonDAO;
import com.revature.exceptions.CourseNotFoundException;
import com.revature.models.Course;
import com.revature.models.Person;
import com.revature.models.Role;
import com.revature.services.CourseService;
import com.revature.services.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class) //this lets us use Mockito!
public class CourseManagementSystemApplicationTests {

	//default test made by spring boot
	@Test
	public void contextLoads() {
	}

	//Remember, Mockito lets us MOCK a class (so we don't need an actual object of the class)
	//why? We often do this with DAOs in order to not mess with actual data while testing

	@Mock //Mocked CourseDAO, which is a dependency of CourseService
	private CourseDAO cDAO;

	@InjectMocks //Injecting the mocked dependency into CourseService
	private CourseService courseService;

	//now, we need to do the same thing for PersonDAO/Service
	@Mock
	private PersonDAO pDAO;

	@InjectMocks //injecting the DAO into the service
	private PersonService personService;

	//Now that we have a CourseService with a mocked CourseDAO...
	//we can run all kinds of tests without worrying about our real data

	//Very simple green test
	// - a test that verifies a method as expected when the user does the right things
	@Test
	public void testGetByIdReturnsCourse(){

		//Stubbing the findById method from courseDAO - not actually calling it!
		when(cDAO.findById(1)).thenReturn(Optional.of(new Course()));

		/* What is Stubbing??
		We're saying "when this method gets called, return this specific thing"
		This facilitates our tests! */

		//Now, we call the findById method of the SERVICE
		Course result = courseService.findCourseById(1);

		//verify that the findById() method get called
		//this is just another step in writing a comprehensive test
		verify(cDAO).findById(1);

		//use our assert method to verify that the result came back with a Course object
		assertNotNull(result);

	}

	//red test - testing that the method works as intended when given invalid arguments
	@Test
	public void testGetCourseByIdThrowsException(){

		//stubbing again, but for id of 0 (which doesn't exist)
		when(cDAO.findById(0)).thenThrow(new CourseNotFoundException("course not found!"));

		//Verify that the expected Exception was thrown
		assertThrows(CourseNotFoundException.class, () -> courseService.findCourseById(0));

	}

	//let's do some PersonService tests
	@Test
	public void testCreatePersonReturnsPerson(){

		//stub the save method from PersonDAO
		//so that when it's called with a Person object argument, it returns that person

		//First, define a valid (enough) Person object
		//the actual data doesn't matter, since the DAO is mocked
		Person p = new Person(1, "john", "doe", new Role(),
				"user", "pass", new ArrayList<Course>());

		//Stubbing - when save() is called in the DAO with person p, return person p
		when(pDAO.save(p)).thenReturn(p);

		//call the service method, which should return a Person
		//...because the save() method from the DAO returns a Person
		Person returnedPerson = personService.createPerson(p);

		//verify that the save() method from the DAO was called
		//verify is just a way to write more robust tests. we can confirm a method was called
		verify(pDAO).save(p);

		//This is a perfectly valid test, but we can be more specific if we want
		//assertNotNull(returnedPerson);

		//making sure that the returned Person has values we would expect.
		assertEquals(returnedPerson.getFirstName(), "john");

		//these two assertions could very well be two separate tests!!!

	}

	//now lets test that createPerson returns null when given an invalid person
	@Test
	public void testCreatePersonReturnsNull() {

		//create an invalid Person (invalid for the DB at least)
		Person p = new Person();

		//stubbing, and we'll just send no args Person in the stubbing
		//if an invalid Person is sent in, we expect a null return
		when(pDAO.save(p)).thenReturn(null);

		//instead of assertNull, we'll test that a NullPointerException is thrown
		assertThrows(NullPointerException.class, () -> personService.createPerson(p));

	}

	@Test
	public void testDeletePersonByIdReturnsTrue(){

//		//stubbing to set deleteById from the DAO to return true, given a valid Id
//		when(pDAO.deleteById(id));

		boolean b = personService.deletePersonById(5);

		//the DAO is mocked, so this^ shouldn't delete any actual data

		//assert that the method, when given a valid value, returns true
		assertTrue(b);
	}

}