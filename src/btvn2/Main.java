package btvn2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EventManager manager = new EventManager();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {

            System.out.println("\n===== EVENT SCHEDULER =====");
            System.out.println("1. Tạo sự kiện");
            System.out.println("2. Tính thời lượng");
            System.out.println("3. Kiểm tra sự kiện sắp diễn ra");
            System.out.println("4. Danh sách sự kiện");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập số hợp lệ.");
                continue;
            }

            switch (choice) {

                case 1:

                    try {

                        System.out.print("Tên sự kiện: ");
                        String name = sc.nextLine();

                        System.out.print(
                                "Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
                        LocalDateTime start =
                                LocalDateTime.parse(
                                        sc.nextLine(),
                                        formatter);

                        System.out.print(
                                "Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
                        LocalDateTime end =
                                LocalDateTime.parse(
                                        sc.nextLine(),
                                        formatter);

                        if (end.isBefore(start)) {
                            System.out.println(
                                    "Thời gian  QÁ  . kết thúc phải sau thời gian bắt đầu.");
                            break;
                        }

                        manager.addEvent(new Event(name, start, end));

                    } catch (DateTimeParseException e) {

                        System.out.println(
                                "Sai định dạng ngày giờ!");
                    }

                    break;

                case 2:

                    manager.displayEvents();

                    break;

                case 3:

                    manager.upcomingEvents();

                    break;

                case 4:

                    manager.displayEvents();

                    break;

                case 5:

                    System.out.println("Thoát chương trình.");
                    return;

                default:

                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
