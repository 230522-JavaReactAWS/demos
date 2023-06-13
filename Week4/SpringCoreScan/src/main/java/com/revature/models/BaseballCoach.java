package com.revature.models;

import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;

public class BaseballCoach implements Coach{

    /*
    Recall that we said with dependency injection we essentially will declare our variables and inject them in some way
    Primarily either Constructor or Setter injection (there's also field injection but there are some problems associated
    with it, so we generally try to avoid it
     */

    // We'll define the fields we want to inject
    private final MotivationalService motivationalService;

    private final WorkoutService workoutService;

    // Constructor Dependency Injection
    public BaseballCoach(MotivationalService motivationalService, WorkoutService workoutService) {
        this.motivationalService = motivationalService;
        this.workoutService = workoutService;
    }

    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("baseball");
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
