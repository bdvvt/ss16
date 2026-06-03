package btvn2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Đã thêm sự kiện.");
    }
    public void displayEvents() {

        if (events.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Event e : events) {
            System.out.println(e);
        }
    }
    public void upcomingEvents() {

        LocalDateTime now = LocalDateTime.now();

        boolean found = false;

        for (Event e : events) {

            if (e.getStartDate().isAfter(now)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sự kiện sắp diễn ra.");
        }
    }
}