package com.example.myapplicationrr;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    public int id;

    @ColumnInfo(name="name",defaultValue="0")
    public String name;

    @ColumnInfo(name="prc",defaultValue="0")
    public int price;

}

