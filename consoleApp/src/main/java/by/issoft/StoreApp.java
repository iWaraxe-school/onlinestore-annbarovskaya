package by.issoft;

import module3.oop.RandomStorePopulator;
import org.reflections.Store;

public class StoreApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        RandomStorePopulator randomstorepopulator = new RandomStorePopulator(onlineStore);
        RandomStorePopulator.populateStore();
        onlineStore.printCategoriesAndProducts();
    }
}
