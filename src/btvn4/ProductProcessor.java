package btvn4;

import java.util.List;
import java.util.function.Predicate;

public interface  ProductProcessor {
    double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product>products){
        System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");
        for (Product product : products) {
            System.out.println(product);
        }
    }
    default boolean hasExpensiveProduct(List<Product> products) {

        Predicate<Product> expensive = product -> product.getPrice() > 100;
        return products.stream()
                .anyMatch(expensive);
    }
}
