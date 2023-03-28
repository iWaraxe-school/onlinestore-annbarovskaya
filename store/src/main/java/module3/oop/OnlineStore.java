package module3.oop;

import ProductComparator.ProductComparator;
import xml.parser.XMLParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OnlineStore {
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
    public void sortProductsByXML() {
        Map<String, String> configMap = XMLParser.xmlHandler();
        ProductComparator comparator = new ProductComparator(configMap);
        List<Product> allProducts = new ArrayList<>();
        for(Category category : categoryList) {
            allProducts.addAll(category.getProducts());
        }
        allProducts.sort(comparator);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    public void sortProductsByPrice() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("price", "desc");
        ProductComparator comparator = new ProductComparator(configMap);
        List<Product> allProducts = new ArrayList<>();
        for(Category category : categoryList) {
            allProducts.addAll(category.getProducts());
        }
        allProducts.sort(comparator);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}

}
