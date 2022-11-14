package module3.oop;

import java.util.ArrayList;

public class PhoneCategory {
    private String name;

    ArrayList<String> products = new ArrayList <String> ();

    public PhoneCategory(String name, int rate, int price) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String Name) {
        this.name = name;
    }
}
