package me.pe4en1e;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWorker {


    public void createTableShop() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/alexanderdubrovin/Desktop/laba5.db");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE shop (id INTEGER PRIMARY KEY, name TEXT, balance REAL NOT NULL)");

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableProduct() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/alexanderdubrovin/Desktop/laba5.db");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE product (id INTEGER PRIMARY KEY, name TEXT, price REAL NOT NULL)");

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableWarehouse() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/alexanderdubrovin/Desktop/laba5.db");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE warehouse (shop_id INTEGER REFERENCES shop (id), product_id INTEGER REFERENCES product (id), quantity INTEGER NOT NULL, PRIMARY KEY (shop_id, product_id))");
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToShop(String name, String balance){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/alexanderdubrovin/Desktop/laba5.db");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shop (name, balance) VALUES (?, ?)");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, balance);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
