package module3.oop;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;


public class RandomStorePopulator {
    OnlineStore onlineStore;

    public RandomStorePopulator(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }

        public void populateStore() {
        RandomProductGenerator generator = new RandomProductGenerator();

        Set<Category> categorySet = createCategorySet();
        for (Category category : categorySet) {
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
                CategoryFactory categoryFactory = new CategoryFactory();
                category = categoryFactory.createCategory(subType.getName());
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