package com.example.myapplicationrr;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//,autoMigrations = {@AutoMigration(from=1,to=2)}
@Database(entities = {com.example.myapplicationrr.Product.class},version=2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract com.example.myapplicationrr.ProductDao productDao();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"PRODUCT").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
