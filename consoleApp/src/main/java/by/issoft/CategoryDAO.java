package by.issoft;

import module3.oop.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDAO {
    private Db connectionManager;

    public CategoryDAO(Db connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void createCategory(Category category) {
        try (Connection connection = Db.getConnection();
             PreparedStatement statement = connection.PrepareStatement("INSERT INTO CATEGORIES(NAME) VALUES(?)")) {
            statement.setString(1, category.getName().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating category: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteCategory(Category category) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.PrepareStatement("DELETE FROM CATEGORIES WHERE  ID=?")) {
            statement.setInt(1, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting category: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
