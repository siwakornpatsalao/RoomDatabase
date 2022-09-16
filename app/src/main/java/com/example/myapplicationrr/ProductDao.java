package com.example.myapplicationrr;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void Insert(Product p);

    @Insert
    void Insert(List<Product> list);

    @Query("SELECT * from product")
    List<Product> getAll();

    @Query("Select * from product where id =:id")
    Product get(int id);
}
