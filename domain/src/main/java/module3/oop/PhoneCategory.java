package module3.oop;

import java.util.ArrayList;
import java.util.List;

public class PhoneCategory extends Category {
    private PhoneCategory() {
        super("Phones");
    }

    private List<String> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addProduct(String product) {
        this.products.add(product);
    }

    public void printCategory() {
    }
}

