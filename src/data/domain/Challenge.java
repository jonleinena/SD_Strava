package data.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Challenge {

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
        return "Challenge{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", distanceGoal=" + distanceGoal +
                ", timeGoal=" + timeGoal +
                ", sport=" + Arrays.toString(sport) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass().getName().equals(obj.getClass().getName())) {
            return this.title.equals(((Challenge)obj).title);
        }

        return false;
    }
}
