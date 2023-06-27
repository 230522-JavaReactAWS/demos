package com.revature;

import com.revature.models.Course;
import com.revature.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);

		// Things get wonky if we try to add in stuff to manually test in our main method here
		// So we implement the command line runner functional interface and go from there
	}

	/*
//	// Bad practice time
//	// Field injection.... looks pretty but can lead to problems down the line including dependency management among
//	// other things
//	@Autowired
//	private CourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		// Inside here we can start doing all our manual testing to make sure our services don't implode

		// Now that we have injected our service bean we *should* be able to test it
		Course course = new Course(0, "Intro to Calculus", "Learn the basics of calc", 4);
		Course course2 = new Course(0, "Calculus and Analytic Geometry II", "Differential Equations", 3);
		Course course3 = new Course(0, "Sports Psychology", "Learn about sports and the mind", 3);


		courseService.addCourse(course);
		courseService.addCourse(course2);
		courseService.addCourse(course3);
//
//		course.setCredits(3);
//
//		courseService.updateCourse(course);
//
//		// We're removing diffy q from the curriculum
//
////		courseService.deleteCourse(2);
//
//		Course returnedCourse = courseService.findCourseById(1);
//		System.out.println(returnedCourse);
//		// I guess we could test our exception
////		System.out.println(courseService.findCourseById(2));
//
//		System.out.println("------------------------------------");
//		System.out.println(courseService.getAllCourses());
//
//		System.out.println(courseService.searchCourses("calc"));
//	}
*/

	// This^^^^ was before we had a controller to do our full testing, we also removed "implements CommandLineRunner"
}
