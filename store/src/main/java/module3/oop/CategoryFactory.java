package module3.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CategoryFactory {
    private static final Map<String, Supplier<Category>> CATEGORY_MAP = new HashMap<String, Supplier<Category>>() {{
        put("BikeCategory", BikeCategory::new);
        put("MilkCategory", MilkCategory::new);
        put("PhoneCategory", PhoneCategory::new);
    }};

    public Category createCategory(String name) {
        Supplier<Category> supplier = CATEGORY_MAP.get(name);
        return (supplier != null) ? supplier.get() : null;
    }
}
