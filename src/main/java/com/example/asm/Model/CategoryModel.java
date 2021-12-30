package com.example.asm.Model;

import com.example.asm.entity.Category;
import com.example.asm.entity.Product;
import com.example.asm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryModel {


    public ArrayList<Category> findAll(){
        ArrayList<Category> result = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from categories");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");

                    String name = resultSet.getString("name");

                    Category category = new Category(id, name);
                    result.add(category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
