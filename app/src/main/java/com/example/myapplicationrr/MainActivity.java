package com.example.myapplicationrr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseAdapter productListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addNewProductButton = findViewById(R.id.button);
        addNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddActivity.class),100);
            }
        });

        initRecyclerView();
        loadProductList();

        //RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new DatabaseAdapter());
        /*
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"dbname").allowMainThreadQueries().build();
        ProductDao dao = db.productDao();

        List<Product> list = new ArrayList();
        //list.add(new Product(8,"iMac",80000));
        //list.add(new Product(9,"Apple Tv",5000));
        //dao.Insert(list);
        //dao.Insert(new Product(7,"Apple Pencil",3400));

         */
    }
    private void  initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        productListAdapter = new DatabaseAdapter(this);
        recyclerView.setAdapter(productListAdapter);
    }
    private  void loadProductList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Product> productList = db.productDao().getAll();
        productListAdapter.setProductList(productList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadProductList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}