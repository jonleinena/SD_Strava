package data.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Workout {

    private String title;
    private String sport;
    private float distance;
    private LocalDate startDate;
    private LocalTime startHour;
    private float duration;

    public Workout(String title, String sport, float distance, LocalDate startDate, LocalTime startHour, float duration) {
        this.title = title;
        this.sport = sport;
        this.distance = distance;
        this.startDate = startDate;
        this.startHour = startHour;
        this.duration = duration;
    }

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
        return "Workout{" +
                "title='" + title + '\'' +
                ", sport='" + sport + '\'' +
                ", distance=" + distance +
                ", startDate=" + startDate +
                ", startHour=" + startHour +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass().getName().equals(obj.getClass().getName())) {
            return this.title.equals(((Workout)obj).title);
        }

        return false;
    }
}
