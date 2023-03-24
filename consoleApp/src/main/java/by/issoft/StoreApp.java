package by.issoft;

import module3.oop.RandomStorePopulator;
import module3.oop.OnlineStore;
import org.reflections.Store;
import xml.parser.XMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class StoreApp {
    public static void
    final String PATH_CONFIG_XML = "src/main/resources/config.xml";
    public static void
    final String COMMAND_TOP = "top";
    public static void
    final String COMMAND_SORT = "sort";
    public static void
    final String COMMAND_PRINT = "print";
    public static void
    final String COMMAND_QUIT = "quit";

    private final Store store;
    private final RandomStorePopulator randomStorePopulator;

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        RandomStorePopulator randomstorepopulator = new RandomStorePopulator(onlineStore);
        randomstorepopulator.populateStore();
        onlineStore.printCategoriesAndProducts();
        Map<String, String> stringStringMap = XMLParser.xmlHandler();
        System.out.println(stringStringMap);

    }
public StoreApp(Store store, RandomStorePopulator randomStorePopulator){
        this.store = store;
    this.randomStorePopulator = randomStorePopulator;
}
    public void run() {
        ProductComparatorStream ProductComparator = new ProductComparatorStream(store);
        randomStorePopulator.populateStore();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean flag = true;
            while (flag) {
                System.out.println("Enter command: print/chart/sort/quit");
                String command = reader.readLine();
                switch (command) {
                    case COMMAND_TOP:
                        ProductComparator.printTopProducts();
                        break;
                    case COMMAND_SORT:
                        try {
                           OnlineStore.printProductsByXML(PATH_CONFIG_XML);
                        } catch (Exception e) {
                            System.out.println("Failed to sort products:" + e.getMessage());
                        }
                        break;
                    case COMMAND_PRINT:
                        OnlineStore.printCategoriesAndProducts();
                        break;
                    case COMMAND_QUIT:
                        flag = false;
                        break;
                    default:
                        System.out.println("Command is not recognized");
                        break;
                }
            }}
            catch (IOException e) {
            System.out.println("Failed to read input: " + e.getMessage());
        }

    }
}
