package com.revature.config;

import com.revature.models.BaseballCoach;
import com.revature.models.FootballCoach;
import com.revature.models.TrackCoach;
import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sound.midi.Track;

/*
So as an alternative to XML based configuration we also have the ability to do the same thing but with a configuration
class itself. We'll heavily use annotations from here to configure our application context (bean container)
 */
@Configuration // This denotes that this class will be used for configuration
public class AppConfig {

    // This class serves as an alternative to our beans.xml file

    @Bean // This is used to declare our beans ... default name is whatever method name is
    public MotivationalService motivationalServiceBean(){
        return new MotivationalService();
    }

    // We can provide a non-default name in the annotation itself
    @Bean("workoutServiceBean")
    @Scope("prototype") // We can change the scope of the bean
    public WorkoutService workoutService(){
        return new WorkoutService();
    }

    // Let's try creating our track coach bean
    @Bean
    public TrackCoach trackCoachBean(){
        return new TrackCoach(workoutService(), motivationalServiceBean());
    }

    // Let's make our baseball coach the same way
    @Bean
    public BaseballCoach baseballCoachBean(){
        return new BaseballCoach(motivationalServiceBean(), workoutService());
    }

    // Last bean we need to do is the football coach
    @Bean
    public FootballCoach footballCoachBean(){
        // SO for the football coach we used SETTER injection instead of constructor

        FootballCoach footballCoach = new FootballCoach();
        // Set all the values using the setters we made
        footballCoach.setMotivationalService(motivationalServiceBean());
        footballCoach.setWorkoutService(workoutService());
        // We can set individual values as usual
        footballCoach.setTeamName("Tampa Bay Bucs");
        footballCoach.setEmail("tod.bowles@bucs.com");

        return footballCoach;
    }
}
