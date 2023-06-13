package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLDriver {
    // This is the class we plan to use to create our application context aka our bean container

    public static void main(String[] args) {
        System.out.println("Creating the Bean Container...");

        try (ClassPathXmlApplicationContext beanContainer = new ClassPathXmlApplicationContext("beans.xml")){

            System.out.println("Bean Container created");
            System.out.println("-------------------------------");

            // So all of the beans we defined are now present in the container and available for use

            TrackCoach trackCoach =  beanContainer.getBean("trackCoachBean", TrackCoach.class);

            // Theoretically I've now created a Track coach object which I can then use to for all it's normal functions
            System.out.println(trackCoach.getDailyWorkout());
            System.out.println(trackCoach.getMotivation());

            // Let's create a new bean for our baseball coach
            BaseballCoach baseballCoach = beanContainer.getBean("baseballCoachBean", BaseballCoach.class);

            // Let's check our values
            System.out.println(baseballCoach.getDailyWorkout());
            System.out.println(baseballCoach.getMotivation());

            // Let's take a look to see if the motivational services are the same between the beans
            System.out.println("Do the coaches have the same motivational service? " +
                    (trackCoach.getMotivationalService() == baseballCoach.getMotivationalService()));
            // == and .equals do the exact same thing unless overridden

            /*
            Spring is doing some management behind the scenes when it wires the beans together
            Spring's default scope for beans is singleton. If we alter the workout service by changing the scope to
            prototype we should be able to see some difference
             */

            System.out.println("Do the coaches have the same workout service? " +
                    (trackCoach.getWorkoutService() == baseballCoach.getWorkoutService()));

            // Now that we've had a look at constructor injection let's take a look at setter injection


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
