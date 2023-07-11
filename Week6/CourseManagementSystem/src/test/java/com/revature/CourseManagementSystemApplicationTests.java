package com.revature;

import com.revature.daos.CourseDAO;
import com.revature.daos.PersonDAO;
import com.revature.exceptions.CourseNotFoundException;
import com.revature.models.Course;
import com.revature.services.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class) //This will allow us to use things like @Mock and @InjectMocks
class CourseManagementSystemApplicationTests {

	//default test that's made by spring boot
	@Test
	void contextLoads() {
	}

	@Mock //Mocking CourseDAO, which is a dependency of CourseService
	private CourseDAO cDAO;

	@InjectMocks //Inject the mocked CourseDAO into CourseService
	private CourseService cService;

	//now that we have a CourseService with a mocked CourseDAO, we can run all kinds of tests!
	//WITHOUT worrying about the actual data in the database

	@Test
	public void testGetAllReturnsValue(){

		//Stubbing the get all method - not actually calling it!!
		when(cDAO.findAll()).thenReturn(new ArrayList<Course>());

		//Call the service method, which should return an ArrayList
		List<Course> result = cService.getAllCourses();

		//Verify that the findAll() method gets called by the getById() method
		verify(cDAO).findAll();

		//Verify that the result is not null (or whatever else you want to test)
		assertNotNull(result);

	}

	@Test
	public void testGetCourseByIdThrowsException(){

		//Stubbing the findById method with an invalid id argument
		when(cDAO.findById(0)).thenThrow(new CourseNotFoundException("Course not found!"));

		//Verify that the appropriate Exception is thrown when 0 is supplied as the ID
		assertThrows(CourseNotFoundException.class, () -> cService.findCourseById(0));

	}

}
