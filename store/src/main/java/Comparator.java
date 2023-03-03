import module3.oop.Product;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        int result = 0;
        XmlReaderToMap parser = new XmlReaderToMap();
        Map<String, String> configMap = parser.configMap();
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            if (entry.getValue().equals("ASC")) {
                switch (entry.getKey()) {
                    case "name":
                        result = p1.getName().compareTo(p2.getName());
                        break;
                    case "rate":
                        result = Double.compare(p1.getRate(), p2.getRate());
                        break;
                    case "price":
                        result = Double.compare(p1.getPrice(), p2.getPrice());
                        break;
                }
            } else if (entry.getValue().equals("DESC")) {
                switch (entry.getKey()) {
                    case "name":
                        result = p2.getName().compareTo(p1.getName());
                        break;
                    case "rate":
                        result = Double.compare(p2.getRate(), p1.getRate());
                        break;
                    case "price":
                        result = Double.compare(p2.getPrice(), p1.getPrice());
                        break;
                }
            }

            if (result != 0) break;
        }
        return result;
    }
}
