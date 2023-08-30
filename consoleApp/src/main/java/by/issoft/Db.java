package by.issoft;

import module3.oop.Category;
import module3.oop.RandomProductGenerator;
import org.reflections.Store;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import static com.mysql.cj.conf.PropertyKey.logger;

public class Db {
    static Connection CONNECTION = null;
    static Statement PreparedStatement = null;
    static Statement PreparedStatement_Enclosed = null;
    static ResultSet RESULTSET = null;
    static ResultSet RESULTSET_ENCLOSED = null;

    static final String URL = "jdbc:mysql://localhost:3306/onlineStore";
    static final String USER = "student";
    static final String PASSWORD = "student";

    Store store;

    public Db(Store store) {
        this.store = store;
    }

    public void dBinit() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            clearDb(statement);
            createCategoryTable(statement);
            createProductTable(statement);

        } catch (SQLException e) {
            System.err.println("Error initializing connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void clearDb(Statement statement) {
        String query1 = "DROP TABLE IF EXISTS CATEGORIES;";
        String query2 = "DROP TABLE IF EXISTS PRODUCTS;";
        String query3 = "DROP TABLE IF EXISTS ORDERS;";
        try {
            PreparedStatement.executeUpdate(query2);
            PreparedStatement.executeUpdate(query1);
            PreparedStatement.executeUpdate(query3);
        } catch (SQLException e) {
            System.err.println("Error clearing database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createCategoryTable() {
        String query = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        try {
            PreparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProductTable(Statement statement) {
        String query = "CREATE TABLE IF NOT EXISTS PRODUCTS (" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "CATEGORY_ID INT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL," +
        "RATE DECIMAL (10, 1) NOT NULL," +
        "PRICE DECIMAL (10, 1) NOT NULL," +
        "FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES());";
        try {
            PreparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error creating product table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void fillStoreRandom() {
        RandomProductGenerator generator = new RandomProductGenerator();
        Set<Category> categorySet = createCategorySet();
        int j = 1;
        for (Category category : categorySet) {
            System.out.println("Insert category " + category.getName() + "into database");
            try {
                PreparedStatement insertCategories = CONNECTION.prepareStatement("INSERT INTO CATEGORIES(NAME) VALUES(?)");
                insertCategories.setString(1, category.getName().toString());
                System.out.println(insertCategories);
                insertCategories.execute();

                Random randomProductAmountToAdd = new Random();
                for (int i = 0; i < randomProductAmountToAdd.nextInt(10) + 1; i++) {
                    PreparedStatement insertProduct = CONNECTION.prepareStatement("INSERT INTO PRODUCTS(category_id, name, rate, price) VALUES (?, ?, ?, ?)");
                    insertProduct.setInt(1, j);
                    insertProduct.setString(2, generator.generateName(category.getId()));
                    insertProduct.setDouble(3, generator.generateRate());
                    insertProduct.setDouble(4, generator.generatePrice());
                    System.out.println(insertProduct);
                    insertProduct.execute();
                    System.out.println("One more product inserted");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
