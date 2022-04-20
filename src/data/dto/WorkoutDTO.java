package data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class WorkoutDTO implements Serializable {

    //This attribute is needed to implement the "Serializable" interface.
    private static final long serialVersionUID = 1L;
    private String title;
    private String sport;
    private float distance;
    private LocalDate startDate;
    private LocalTime startHour;
    private float duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WorkoutDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", sport='").append(sport).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(", startDate=").append(startDate);
        sb.append(", startHour=").append(startHour);
        sb.append(", duration=").append(duration);
        sb.append('}');
        return sb.toString();
    }
}

