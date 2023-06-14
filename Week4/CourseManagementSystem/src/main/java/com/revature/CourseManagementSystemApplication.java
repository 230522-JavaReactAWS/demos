package com.revature;

import com.revature.models.Course;
import com.revature.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);

		// Things get wonky if we try to add in stuff to manually test in our main method here
		// So we implement the command line runner functional interface and go from there
	}

	// Bad practice time
	// Field injection.... looks pretty but can lead to problems down the line including dependency management among
	// other things
	@Autowired
	private CourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		// Inside here we can start doing all our manual testing to make sure our services don't implode

		// Now that we have injected our service bean we *should* be able to test it
		Course course = new Course(0, "Intro to Calculus", "Learn the basics of calc", 4);
		courseService.addCourse(course);
	}
}
