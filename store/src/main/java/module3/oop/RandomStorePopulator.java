package module3.oop;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RandomStorePopulator {
    Store store;

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

    public void populateStore() {
        RandomProductGenerator generator = new RandomProductGenerator();
        Product bike = generator.generateProduct(Categories.BIKES);

        Set<Category> categorySet = createCategorySet();
        for (Category category : CategorySet) {
            for (int i = 0; i < new Random().nextInt(10) + 1; i++) {
                Product product = generator.generateProduct(category.getName());
                category.addProductToCategory(product);
            }
        }
    }

    private Set<Category> createCategorySet() {
        Set<Category> categorySet = new HashSet<Category>();
        return categorySet;
    }
}