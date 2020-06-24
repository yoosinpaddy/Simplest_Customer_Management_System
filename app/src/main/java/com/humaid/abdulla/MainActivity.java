package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button add,del,display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.addCustomer);
        del=findViewById(R.id.deleteCustomer);
        display=findViewById(R.id.displayCustomers);
        //add when button is clicked
        add.setOnClickListener(this::addCustomer);
        //delete when button is clicked
        del.setOnClickListener(this::delCustomer);
        //display when button is clicked
        display.setOnClickListener(this::displayCustomer);
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