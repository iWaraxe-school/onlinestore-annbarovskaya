package module3.oop;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;


public class RandomStorePopulator {
    Store store;

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

    public void populateStore() {
        RandomProductGenerator generator = new RandomProductGenerator();

        Set<Category> categorySet = createCategorySet();
        for (Category category : CategorySet) {
            for (int i = 0; i < new Random().nextInt(10) + 1; i++) {
                Product product = generator.generateProduct(category.getName());
                category.addProduct(product);
            }
        }
    }

    private Set<Category> createCategorySet() {
        Set<Category> categorySet = new HashSet<Category>();
        Reflections reflections = new Reflections("com.my.project");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());
        for (Class subType : subTypes) {
            Category category = null;
            try {
                category = (Category) subType.getConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            categorySet.add(category);
        }
        return categorySet;
    }
}