package module3.oop;

public class Product {
    private String name;
    private int rate;
    private int price;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() { return name; }

    public void setName(String Name) {
        this.name = name;
    }

    public Integer getRate() {return rate; }

    public void setRate(int Rate) {
        this.rate = rate;
    }

    public Integer getPrice() {return price; }

    public void setPrice(int price) {
        this.price = price;
    }
}
