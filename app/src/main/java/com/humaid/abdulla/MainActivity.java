package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.humaid.abdulla.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //add when button is clicked
        b.addCustomer.setOnClickListener(this::addCustomer);
        //delete when button is clicked
        b.deleteCustomer.setOnClickListener(this::delCustomer);
        //display when button is clicked
        b.displayCustomers.setOnClickListener(this::displayCustomer);
    }
    public void addCustomer(View v){
        startActivity(new Intent(this, AddActivity.class));
    }
    public void delCustomer(View v){
        startActivity(new Intent(this, DeleteActivity.class));
    }
    public void displayCustomer(View v){
        startActivity(new Intent(this, DisplayActivity.class));
    }
}