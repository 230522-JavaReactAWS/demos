package com.revature.models;

import com.revature.service.MotivationalService;
import com.revature.service.WorkoutService;

public class FootballCoach implements Coach{
    // In my football coach class I'll be using setter injection

    // To use setter injection we need to provide the fields, a no args constructions and our mutators for our fields

    private String email;

    private String teamName;

    private WorkoutService workoutService;

    private MotivationalService motivationalService;

    /*
    Private and not private final --> final mandates that the value be initialized in the constructor but we don't want
    that to happen. We use setter injection for non-mandatory injections.
     */

    public FootballCoach(){
        System.out.println("Football Coach Initialized");
    }


    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("football");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    public void setMotivationalService(MotivationalService motivationalService) {
        this.motivationalService = motivationalService;
    }
}
