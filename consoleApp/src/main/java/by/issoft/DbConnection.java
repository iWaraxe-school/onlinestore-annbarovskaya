package by.issoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/onlinestore";
    private static final String USER = "student";
    private static final String PASSWORD = "student";

    public DbConnection() {
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection((URL, USER, PASSWORD));
        }
        public static void  closeConnection(Connection connection) throws SQLException {
            if  (connection = null) {
                connection.close();
            }
        }
    }
}
