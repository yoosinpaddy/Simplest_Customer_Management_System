package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.humaid.abdulla.databinding.ActivityDisplayBinding;
import com.humaid.abdulla.room.config.DatabaseClient;
import com.humaid.abdulla.room.tables.CustomerTable;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    ActivityDisplayBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_display);
        //Retrieving list of customers
        getCustomerList();
    }

    private void getCustomerList() {
        @SuppressLint("StaticFieldLeak")
        class GetCustomerList extends AsyncTask<Void, Void, List<CustomerTable>> {
            @Override
            protected List<CustomerTable> doInBackground(Void... voids) {
                //Query database
                return DatabaseClient
                        .getInstance(DisplayActivity.this)
                        .getAppDatabase()
                        .customerDao()
                        .getAllpeople();

            }

            @Override
            protected void onPostExecute(List<CustomerTable> v) {
                //Retrieving list of customers
                b.customerRecycler.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));
                //displaying in the adapter
                b.customerRecycler.setAdapter(new CustomerAdapter(DisplayActivity.this,v));
            }
        }

        GetCustomerList gh = new GetCustomerList();
        gh.execute();
    }
}