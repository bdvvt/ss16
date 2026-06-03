package btvn4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 30));

        products.add(new Product("Mouse", 50));

        products.add(new Product("Keyboard", 20));

        products.add(new Product("USB", 20));

        ProductProcessor processor =new ProductProcessorImpl();

        if (processor.hasExpensiveProduct(products)) {

            System.out.println("Có sản phẩm đắt tiền (>100)");

        } else {

            System.out.println("Không có sản phẩm đắt tiền");
        }

        double total =processor.calculateTotalValue(products);

        System.out.println("\nTổng giá trị sản phẩm: " + total);

        ProductProcessor.printProductList(products);
    }
}
