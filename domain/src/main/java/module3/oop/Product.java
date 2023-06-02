package module3.oop;

import java.util.Locale;

public class Product {
    private String name;
    private double rate;
    private double price;

    private Product(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.price = builder.price;
    }
    public static class Builder {
        private String name;
        private Double rate;
        private Double price;

        public Builder() {}

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withRate(Double rate) {
            this.rate = rate;
            return this;
        }

        public Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
    public String getName() {
        return name;
    }


    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String productInfo;
        return productInfo = String.format("Name: %s, Price: %s, Rate: %s", name, price, rate);
    }

}
