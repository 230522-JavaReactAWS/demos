package com.revature.service;

public class WorkoutService {

    // Again we'll pretend this pulls from some workout service that allows us to get sport specific workouts

    public WorkoutService(){
        // Unnecessary but will help for visualization later
        System.out.println("Workout service initialized");
    }

    // We'll pretend this method is making a call to an api
    public String fetchWorkoutRoutine(String coachType){
        // We'll use a switch case bc why not
        switch (coachType.toLowerCase()){
            case "baseball":
                return "Today's Workout: Spend an hour at batting practice";
            case "track":
                return "Today's Workout: Run a 5k in 30 minutes";
            case "football":
                return "Today's Workout: Suicide runs to the 40, 50, 60, 70, 80, 90, and 100 yard lines";
            default:
                return "No workout to provide. Enjoy your rest day!";
        }
    }
}
