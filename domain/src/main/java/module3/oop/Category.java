package module3.oop;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;

    private List<Product> products = new ArrayList<>();


    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void printCategory() {
        System.out.println("Category: " + name + ".");
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
