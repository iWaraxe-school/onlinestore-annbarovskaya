import module3.oop.Product;

public class Comparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2)
    {
        int nameCompare = p1.getName().compareTo(p2.getName());
        if (nameCompare !=0) {
            return nameCompare;
        }
        int ratingCompare = Double.compare(p1.getRate(), p2.getRate());
        if (ratingCompare !=0) {
            return ratingCompare;
        }
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
