package com.example.asm.entity;

import com.example.asm.annotation.Column;
import com.example.asm.annotation.Entity;
import com.example.asm.util.SQLDataTypes;

@Entity(tableName = "categories")
public class Category {
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR50)
    private String name;

    public Category(int id, String name) {

        this.name = name;
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
}
