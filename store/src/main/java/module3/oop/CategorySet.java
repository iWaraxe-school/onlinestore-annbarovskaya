package module3.oop;

import org.reflections.Reflections;

import static org.reflections.scanners.Scanners.*;

import java.util.Set;

public class CategorySet {
    private Reflections reflections = new Reflections("com.my.project");
    Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());
    Category category = subType.getConstructor().newInstance();
}
