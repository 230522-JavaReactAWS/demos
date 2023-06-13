package com.revature.models;

import com.revature.service.MotivationalService;

public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getMotivation() {
        return null;
    }

    @Override
    public MotivationalService getMotivationalService() {
        return null;
    }
}
