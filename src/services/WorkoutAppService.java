package services;

import data.domain.User;
import data.domain.Workout;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkoutAppService {

    private static WorkoutAppService instance;

    private WorkoutAppService() {}

    public static WorkoutAppService getInstance(){
        if (instance == null){
            instance = new WorkoutAppService();
        }  return instance;

    }
    public boolean createWorkout(User user, String title, String sport, float distance, LocalDate startDate, LocalTime startHour, float duration){
        if(user != null){
            user.addWorkout(new Workout(title, sport, distance, startDate, startHour, duration));
            System.out.println("Workout added!");
            return true;
        } else return false;

    }



}
