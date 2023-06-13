package com.revature.models;

import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;

public interface Coach {

    // Recall that an interface is just a contract to describe what kinds of methods we expect our implementing class
    // to have (as a baseline, it could always have more)

    String getDailyWorkout();

    String getMotivation();

    // We'll also make sure anybody can get the motivational service
    MotivationalService getMotivationalService();

    WorkoutService getWorkoutService();
}
