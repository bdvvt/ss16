package btvn3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MessageManager manager =
                new MessageManager();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {

            System.out.println("\n===== CHAT APP =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử chat");
            System.out.println("3. Lọc theo người gửi");
            System.out.println("4. Lọc theo ngày");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");

            int choice;

            try {
                choice =
                        Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Nhập số!");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Người gửi: ");
                    String sender =
                            sc.nextLine();

                    System.out.print("Nội dung: ");
                    String content =
                            sc.nextLine();

                    manager.sendMessage(
                            sender,
                            content);

                    break;

                case 2:

                    manager.showMessages();

                    break;

                case 3:

                    System.out.print(
                            "Nhập tên người gửi: ");

                    String searchSender =
                            sc.nextLine();

                    manager.filterBySender(
                            searchSender);

                    break;

                case 4:

                    try {

                        System.out.print(
                                "Nhập ngày (dd/MM/yyyy): ");

                        String input =
                                sc.nextLine();

                        LocalDate date =
                                LocalDate.parse(
                                        input,
                                        formatter);

                        manager.filterByDate(date);

                    }
                    catch (DateTimeParseException e) {

                        System.out.println(
                                "Sai định dạng ngày! "
                                        + "Ví dụ: 20/06/2026");
                    }

                    break;

                case 5:

                    System.out.println(
                            "Thoát chương trình.");
                    return;

                default:

                    System.out.println(
                            "Lựa chọn không hợp lệ.");
            }
        }
    }
}
