package com.humaid.abdulla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerVH> {
    Context c;
    List<CustomerTable> customers;

    public CustomerAdapter(Context c, List<CustomerTable> customers) {
        this.c = c;
        this.customers = customers;
    }

    @NonNull
    @Override
    public CustomerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerVH(LayoutInflater.from(c).inflate(R.layout.item_customer,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerVH holder, int position) {
        CustomerTable one=customers.get(position);
        holder.idTv.setText(one.getId());
        holder.nameTv.setText(one.getName());
        holder.prefTv.setText(one.getPreference());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    class CustomerVH extends RecyclerView.ViewHolder{

        TextView idTv;
        TextView nameTv;
        TextView prefTv;
        public CustomerVH(@NonNull View itemView) {
            super(itemView);
            idTv=itemView.findViewById(R.id.idTv);
            nameTv=itemView.findViewById(R.id.nameTv);
            prefTv=itemView.findViewById(R.id.prefTv);
        }
    }
}
