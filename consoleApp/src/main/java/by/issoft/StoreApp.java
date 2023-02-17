package by.issoft;

import module3.oop.RandomStorePopulator;
import module3.oop.Store;
import xml.parser.XMLParser;

import java.util.Map;

public class StoreApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        RandomStorePopulator randomstorepopulator = new RandomStorePopulator(onlineStore);
        randomstorepopulator.populateStore();
        onlineStore.printCategoriesAndProducts();
        Map<String, String> stringStringMap = XMLParser.xmlHandler();
        System.out.println(stringStringMap);

    }
}
