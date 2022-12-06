package module3.oop;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

public class RandomStorePopulator {

    public static void main(String args[]) {
        Faker faker = new Faker();

        String name = faker.commerce().productName();
        String rate = faker.number().digits(6);
        String price = faker.number().digits(6);


        System.out.println("Name:" + name);
        System.out.println("Rate:" + rate);
        System.out.println("Price:" + price);
    }
}