package btvn1;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    private HashMap<Integer, Product> productHashMap = new HashMap<>();
    public void  addProduct(Product product) {
        if (productHashMap.containsKey(product.getId())){
            System.out.println("ID đã tồn tại");
            return;
        }
        productHashMap.put(product.getId(), product);
        System.out.println("Product added successfully.");
    }
    public void updateProduct(int id,String newName,double newPrice){
        Product product = productHashMap.get(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        product.setName(newName);
        product.setPrice(newPrice);

        System.out.println("Product updated successfully.");
    }
    public void deleteProduct(int id) {

        if (productHashMap.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showProducts() {

        if (productHashMap.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Map.Entry<Integer, Product> entry : productHashMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    public void filterProducts() {
        System.out.println("Products with price > 100");
        productHashMap.values()
                .stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }
    public void totalValue() {
        double total = productHashMap.values()
                        .stream()
                        .mapToDouble(Product::getPrice)
                        .sum();
        System.out.println("Total value of products: " + total);
    }
}
