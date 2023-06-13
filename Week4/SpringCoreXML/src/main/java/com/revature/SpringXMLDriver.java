package com.revature;

import com.revature.models.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLDriver {
    // This is the class we plan to use to create our application context aka our bean container

    public static void main(String[] args) {
        System.out.println("Creating the Bean Container...");

        try (ClassPathXmlApplicationContext beanContainer = new ClassPathXmlApplicationContext("beans.xml")){

            System.out.println("Bean Container created");

            // So all of the beans we defined are now present in the container and available for use

            TrackCoach trackCoach =  beanContainer.getBean("trackCoachBean", TrackCoach.class);

            // Theoretically I've now created a Track coach object which I can then use to for all it's normal functions
            System.out.println(trackCoach.getDailyWorkout());
            System.out.println(trackCoach.getMotivation());


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
