package com.example.asm.entity;

import com.example.asm.annotation.Column;
import com.example.asm.annotation.Entity;
import com.example.asm.annotation.Id;
import com.example.asm.util.SQLDataTypes;

import java.util.ArrayList;
import java.util.HashMap;

@Entity(tableName = "products")
public class Product {

    @Id(autoIncrement = true)
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR50)
    private String name;
    @Column(columnName = "idDM", columnType = SQLDataTypes.VARCHAR50)
    private String idDM;
    @Column(columnName = "description", columnType = SQLDataTypes.VARCHAR255)
    private String description;
    @Column(columnName = "thumbnail", columnType = SQLDataTypes.TEXT)
    private String thumbnail;
    @Column(columnName = "price", columnType = SQLDataTypes.DOUBLE)
    private double price;
    @Column(columnName = "sellday", columnType = SQLDataTypes.VARCHAR255)
    private String sellday;
    @Column(columnName = "editday", columnType = SQLDataTypes.VARCHAR255)
    private String editday;
    @Column(columnName = "status", columnType = SQLDataTypes.VARCHAR255)
    private String status;

    public Product(int id, String name, String idDM, String status, String description, String thumbnail, double price, String sellday, String editday) {
        this.name = name;
        this.idDM = idDM;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.sellday = sellday;
        this.editday = editday;
        this.status = status;
    }

    public Product() {
        this.name = "";
        this.idDM = "";
        this.description = "";
        this.thumbnail = "";
        this.price = 0;
        this.sellday = "";
        this.editday = "";
        this.status = "";
    }

    public Product(String name, String idDM, String description, String thumbnail, double price, String sellday, String editday, String status) {
        this.name = name;
        this.idDM = idDM;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.sellday = sellday;
        this.editday = editday;
        this.status = status;
    }



    public boolean isValid(){
        return getErrors().size() == 0;
    }

    public HashMap<String, String> getErrors(){
        HashMap<String, String> errors = new HashMap<>();
        if(name == null || name.length() == 0){
            errors.put("name","Please enter product name");
        } else if(name.length() < 3 || name.length() > 50){
            errors.put("name","Please enter at least 3 characters!");
        }
        if(description == null || description.length() == 0){
            errors.put("description","Please enter product description");
        }
        if(thumbnail == null || thumbnail.length() == 0){
            errors.put("thumbnail","Please enter URL");
        }
        return errors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getIdDM() {
        return idDM;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellday() {
        return sellday;
    }

    public void setSellday(String sellday) {
        this.sellday = sellday;
    }

    public String getEditday() {
        return editday;
    }

    public void setEditday(String editday) {
        this.editday = editday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
