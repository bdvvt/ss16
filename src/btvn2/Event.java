package btvn2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "endDate=" + endDate +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
