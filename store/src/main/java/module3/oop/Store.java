package module3.oop;

import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Category> categoryList = new ArrayList<>();

    public void addCategory(Category category) {
        this.categoryList.add(category);
    }

    public void printCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printCategory();
        }
    }
    public void sortAllProducts() {
        ProductComparator comparator = new ProductComparator();
        List<Product> allProducts = new ArrayList<>();
        for(Category category : categoryList) {
            allProducts.addAll(category.getProducts())
        }
        allProducts.sort(comparator);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
