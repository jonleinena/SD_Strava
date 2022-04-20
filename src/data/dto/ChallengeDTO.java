package data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class ChallengeDTO implements Serializable {

    //This attribute is needed to implement the "Serializable" interface.
    private static final long serialVersionUID = 1L;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private float distanceGoal;
    private float timeGoal;
    private String[] sport;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public float getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(float distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public float getTimeGoal() {
        return timeGoal;
    }

    public void setTimeGoal(float timeGoal) {
        this.timeGoal = timeGoal;
    }

    public String[] getSport() {
        return sport;
    }

    public void setSport(String[] sport) {
        this.sport = sport;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChallengeDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", distanceGoal=").append(distanceGoal);
        sb.append(", timeGoal=").append(timeGoal);
        sb.append(", sport=").append(sport == null ? "null" : Arrays.asList(sport).toString());
        sb.append('}');
        return sb.toString();
    }
}
