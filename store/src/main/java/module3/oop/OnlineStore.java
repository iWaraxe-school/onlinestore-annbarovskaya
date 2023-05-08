package module3.oop;

import xml.parser.XMLParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OnlineStore {
    public static final byte MAX_NUMBER_OF_PRODUCTS = 5;
    private static List<Category> categoryList = new ArrayList<>();

    public void addCategory(Category category) {
        this.categoryList.add(category);
    }

    public void printCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printCategory();
        }
    }

    public List<Product> allStoreProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (Category category : categoryList) {
            allProducts.addAll(category.getProducts());
        }
        return allProducts;
    }

    public void sortProductsByXML() {
        Map<String, String> configMap = XMLParser.xmlHandler("src/main/resources/config.xml");
        ProductComparator comparator = new ProductComparator(configMap);
        List<Product> allProducts = allStoreProducts();
        allProducts.sort(comparator);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }

    public void sortProductsByPrice() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("price", "desc");
        ProductComparator comparator = new ProductComparator(configMap);
        List<Product> allProducts = allStoreProducts();
        allProducts.sort(comparator);
        for (Product product : allProducts.subList(0, MAX_NUMBER_OF_PRODUCTS)) {
            System.out.println(product);
        }
    }

    public static class onlineStoreEE {
        private static final onlineStoreEE INSTANCE = new onlineStoreEE();

        private onlineStoreEE() {
        }

        public static onlineStoreEE getInstance() {
            return INSTANCE;
        }
    }

}
