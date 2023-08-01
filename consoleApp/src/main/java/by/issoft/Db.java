package by.issoft;

import org.reflections.Store;

import java.sql.*;

public class Db {
    static Connection CONNECTION = null;
    static Statement STATEMENT = null;
    static Statement STATEMENT_ENCLOSED = null;
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
        connectToDb();
        clearDb();
        createCategoryTable();
        createProductTable();
        
    }
    public void connectToDb() {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("\nDatabase connection successful\n");
            STATEMENT = CONNECTION.createStatement();
            STATEMENT_ENCLOSED = CONNECTION.createStatement();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void clearDb() {
        String query1 = "DROP TABLE IF EXISTS CATEGORIES;";
        String query2 = "DROP TABLE IF EXISTS PRODUCTS;";
        String query3 = "DROP TABLE IF EXISTS ORDERS;";
        try {
            STATEMENT.executeUpdate(query2);
            STATEMENT.executeUpdate(query1);
            STATEMENT.executeUpdate(query3);
        } catch (SQLException e) {
    }}
        public void createCategoryTable() {
        String query = "CREATE TABLE IF NOT EXIST CATEGORIES {" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        try {STATEMENT.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }
    public void createProductTable() {
        String query = "CREATE TABLE IF NOT EXIST PRODUCTS {" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        try {STATEMENT.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }
}
