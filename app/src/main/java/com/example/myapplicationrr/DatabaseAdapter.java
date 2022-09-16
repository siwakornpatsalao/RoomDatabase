package com.example.myapplicationrr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.Holder> {

    private Context context;
    private List<Product> productList;

    public DatabaseAdapter(Context context){
        this.context = context;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.id.setText("ProductID:" +this.productList.get(position).id);
        holder.id.setText("ProductName:" +this.productList.get(position).name);
        holder.id.setText("price:" +this.productList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        TextView price;
        public Holder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.Id);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
