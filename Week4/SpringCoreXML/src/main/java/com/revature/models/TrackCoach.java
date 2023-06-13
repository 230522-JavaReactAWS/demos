package com.revature.models;

import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;

public class TrackCoach implements Coach{

    // We'll do the same thing here as our baseball coach
    // We'll leverage our constructor dependency injection to inject our service
    private final WorkoutService workoutService;

    private final MotivationalService motivationalService;

    // Constructor dependency injection
    public TrackCoach(WorkoutService workoutService, MotivationalService motivationalService) {
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
}
