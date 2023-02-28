import module3.oop.Product;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int comparingByName() {
        Comparator<Product>productNameComparator = Comparator.comparing(Product::getName, (p1, p2))
        return p2.compareTo(p1);
    }
    public int comparingByPrice() {
        Comparator<Product>productPriceComparator = Comparator.comparing(Product::getPrice, (p1, p2))
        return p2.compareTo(p1);
    }
    public int comparingByRate() {
        Comparator<Product>productRateComparator = Comparator.comparing(Product::getRate, (p1, p2))
        return p2.compareTo(p1);
    }

}
