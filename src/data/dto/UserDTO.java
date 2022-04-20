package data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//This class implements the DTO pattern
public class UserDTO implements Serializable {

    //This attribute is needed to implement the "Serializable" interface.
    private static final long serialVersionUID = 1L;
    private String email;
    private String name;
    private LocalDate birthDate;
    private float weight;
    private float height;
    private int maxPPM;
    private int restPPM;
    private List<WorkoutDTO> workouts;
    private List<ChallengeDTO> challenges;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<WorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ChallengeDTO> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<ChallengeDTO> challenges) {
        this.challenges = challenges;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", maxPPM=").append(maxPPM);
        sb.append(", restPPM=").append(restPPM);
        sb.append('}');
        return sb.toString();
    }
}
