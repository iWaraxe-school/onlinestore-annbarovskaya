package by.issoft;

import module3.oop.*;
import threads.ClearOrder;
import threads.CreateOrder;
import xml.parser.XMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StoreApp {
    private static final String PATH_CONFIG_XML = "src/main/resources/config.xml";
    private static final String COMMAND_TOP = "top";
    private static final String COMMAND_SORT = "sort";
    private static final String COMMAND_PRINT = "print";
    private static final String COMMAND_QUIT = "quit";

    private final OnlineStore store;
    private final RandomStorePopulator randomStorePopulator;

    public static void main (String[] args) {
        OnlineStore onlineStore = OnlineStore.getInstance();
        CategoryFactory categoryFactory = new CategoryFactory();
        RandomStorePopulator randomstorepopulator = new RandomStorePopulator(onlineStore);
        StoreApp storeApp = new StoreApp(onlineStore, randomstorepopulator);
        storeApp.run();
        Map<String, String> stringStringMap = XMLParser.xmlHandler("src/main/resources/config.xml");
        System.out.println(stringStringMap);

    }
    BlockingQueue<Product> orderQueue = new ArrayBlockingQueue<>(10);
    Runnable clearOrder = new ClearOrder(orderQueue);
    new Thread(clearOrder).start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public StoreApp(OnlineStore store, RandomStorePopulator randomStorePopulator) {
        this.store = store;
        this.randomStorePopulator = randomStorePopulator;
    }

    public void run() {
        randomStorePopulator.populateStore();
        store.printCategoriesAndProducts();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean flag = true;
            while (flag) {
                System.out.println("Enter command: print/top/sort/quit");
                String command = reader.readLine();
                switch (command) {
                    case COMMAND_TOP:
                        store.sortProductsByPrice();
                        break;
                    case COMMAND_SORT:
                        try {
                            store.sortProductsByXML();
                        } catch (Exception e) {
                            System.out.println("Failed to sort products:" + e.getMessage());
                        }
                        break;
                    case "order":
                        Runnable createOrder = new CreateOrder(orderQueue);
                        new Thread(createOrder).start();
                        break;
                    case COMMAND_PRINT:
                        store.printCategoriesAndProducts();
                        break;
                    case COMMAND_QUIT:
                        flag = false;
                        break;
                    default:
                        System.out.println("Command is not recognized");
                        break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Failed to read input: " + e.getMessage());
        }

    }
}
