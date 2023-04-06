package module3.oop;

import java.util.Comparator;
import java.util.Map;

public class ProductComparator implements Comparator<Product> {
    private final Map<String, String> configMap;
    public ProductComparator(Map<String, String> configMap) {
        this.configMap = configMap;
    }
    @Override
    public int compare(Product p1, Product p2) {
        int result = 0;
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "name":
                    result = value.equals("ASC") ? p1.getName().compareTo(p2.getName())
                            : p2.getName().compareTo(p1.getName());
                    break;
                case "rate":
                    result = value.equals("ASC") ? Double.compare(p1.getRate(), p2.getRate())
                            : Double.compare(p2.getRate(), p1.getRate());
                    break;
                case "price":
                    result = value.equals("ASC") ? Double.compare(p1.getPrice(), p2.getPrice())
                            : Double.compare(p2.getPrice(), p1.getPrice());
                    break;
            }
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}