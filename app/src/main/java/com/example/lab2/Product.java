package com.example.lab2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "name")
    public String name;
}
