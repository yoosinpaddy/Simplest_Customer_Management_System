package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    List<CustomerTable> customerTables= new ArrayList<>();
    RecyclerView customerRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        customerRecycler=findViewById(R.id.customerRecycler);
        //Retrieving list of customers
        getCustomerList();
    }

    private void getCustomerList() {
        SQLiteDatabase db =openOrCreateDatabase("user",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS customers ( id  text NOT NULL, name text NOT NULL,  preference text NOT NULL);");
        Cursor c=db.rawQuery("SELECT * from people",null);
        while (c.moveToNext()){
            customerTables.add(new CustomerTable(c.getString(0),c.getString(1),c.getString(2)));
        }
        //Retrieving list of customers
        customerRecycler.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));
        //displaying in the adapter
        customerRecycler.setAdapter(new CustomerAdapter(DisplayActivity.this,customerTables));
    }
}