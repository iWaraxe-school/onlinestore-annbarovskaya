package module3.oop;

import java.util.Locale;

public class Product {
    private String name;
    private double rate;
    private double price;
    private String productInfo;

    private Product(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.price = builder.price;
    }
public static class Builder {
    private String name;
    private Double rate;
    private Double price;
    public Builder(){
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withRate(Double rate) {
            this.rate = rate;
            return this;
        }
        public Builder withPrice(String price) {
            this.price = price;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productInfo = String.format("Name: %s, Price: %s, Rate: %s", name, price, rate);
    }

}
