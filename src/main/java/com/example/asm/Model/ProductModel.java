package com.example.asm.Model;

import com.example.asm.entity.Product;
import com.example.asm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel {
    public static void main(String[] args) {
       ProductModel productModel = new ProductModel();
//       // productModel.save(new Product("Demo",1,"demo","demo",200,"demo","demo",1));
//        ArrayList<Product> listGame = productModel.findAll();
//        System.out.println(listGame.size());
        productModel.delete(1);
    }

    public ArrayList<Product> findAll(){
        ArrayList<Product> result = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from products");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String idDM = resultSet.getString("idDM");
                    String status = resultSet.getString("status");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String thumbnail = resultSet.getString("thumbnail");
                    String sellday = resultSet.getString("sellday");
                    String editday = resultSet.getString("editday");
                    double price = resultSet.getDouble("price");
                    Product product = new Product(id, name, idDM, status, description, thumbnail , price, sellday, editday);
                    result.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean save(Product product) {
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into products (name, idDM, description,thumbnail, price,sellday,editday, status) values (?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2,product.getIdDM());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setString(4, product.getThumbnail());
                preparedStatement.setDouble(5, product.getPrice());
                preparedStatement.setString(6, product.getSellday());
                preparedStatement.setString(7, product.getEditday());
                preparedStatement.setString(8,product.getStatus());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean delete(int id){
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("delete from products where id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
