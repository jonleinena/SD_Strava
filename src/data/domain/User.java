package data.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    private float weight;
    private float height;
    private int maxPPM;
    private int restPPM;
    private List<Workout> workouts = new ArrayList<>();
    private List<Challenge> challenges = new ArrayList<>();



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getMaxPPM() {
        return maxPPM;
    }

    public void setMaxPPM(int maxPPM) {
        this.maxPPM = maxPPM;
    }

    public int getRestPPM() {
        return restPPM;
    }

    public void setRestPPM(int restPPM) {
        this.restPPM = restPPM;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public void addWorkout(Workout w){
        if(w!= null && ! this.workouts.contains(w)){
            this.workouts.add(w);
        }
    }

    public void addChallenge(Challenge c){
        if(c != null && ! this.challenges.contains(c)){
            this.challenges.add(c);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", height=" + height +
                ", maxPPM=" + maxPPM +
                ", restPPM=" + restPPM +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass().getName().equals(obj.getClass().getName())) {
            return this.email.equals(((User)obj).email);
        }

        return false;
    }
}
