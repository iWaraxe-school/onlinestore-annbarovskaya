package module3.oop;

import com.github.javafaker.Faker;

public class RandomProductGenerator {


    private Faker faker = new Faker();

    private String generateProductName(String categoryName) {
        switch (categoryName) {
            case "Bikes":
                return faker.commerce().productName();
            case "Milk":
                return faker.food().ingredient();
            case "Phones":
                return faker.commerce().productName();
            default:
                return null;
        }
    }

    private double generatePrice() {
        return faker.number().randomDouble(2, 0, 200);
    }

    private double generateRate() {
        return faker.number().randomDouble(1, 0, 5);
    }
}