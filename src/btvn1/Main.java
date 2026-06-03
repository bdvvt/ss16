package btvn1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        while (true) {

            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            int choice =
                    Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int id =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Product Name: ");
                    String name =
                            sc.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price =
                            Double.parseDouble(sc.nextLine());

                    manager.addProduct(
                            new Product(id, name, price));

                    break;

                case 2:

                    System.out.print("Enter Product ID to edit: ");
                    int editId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter new Product Name: ");
                    String newName =
                            sc.nextLine();

                    System.out.print("Enter new Product Price: ");
                    double newPrice =
                            Double.parseDouble(sc.nextLine());

                    manager.updateProduct(
                            editId,
                            newName,
                            newPrice);

                    break;

                case 3:

                    System.out.print("Enter Product ID to delete: ");
                    int deleteId =
                            Integer.parseInt(sc.nextLine());

                    manager.deleteProduct(deleteId);

                    break;

                case 4:

                    manager.showProducts();

                    break;

                case 5:

                    manager.filterProducts();

                    break;

                case 6:

                    manager.totalValue();

                    break;

                case 0:

                    System.out.println("Exit!");
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}
