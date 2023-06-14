package com.revature.models;

import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("trackCoachBean")
public class TrackCoach implements Coach{

    // We'll do the same thing here as our baseball coach
    // We'll leverage our constructor dependency injection to inject our service
    private final WorkoutService workoutService;

    private final MotivationalService motivationalService;

    // Constructor dependency injection
    @Autowired
    public TrackCoach(WorkoutService workoutService, MotivationalService motivationalService) {
        System.out.println("Track Coach Initialized");
        this.workoutService = workoutService;
        this.motivationalService = motivationalService;
    }


    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("track");
    }

    @Override
    public String getMotivation() {
        return motivationalService.fetchMotivationalQuote();
    }

    @Override
    public MotivationalService getMotivationalService() {
        return this.motivationalService;
    }

    @Override
    public WorkoutService getWorkoutService() {
        return this.workoutService;
    }
}
