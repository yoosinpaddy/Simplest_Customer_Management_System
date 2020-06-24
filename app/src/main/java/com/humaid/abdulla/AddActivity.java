package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.humaid.abdulla.databinding.ActivityAddBinding;
import com.humaid.abdulla.room.config.DatabaseClient;
import com.humaid.abdulla.room.tables.CustomerTable;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_add);
        //add data when add button is clicked
        b.add.setOnClickListener(this::addData);
    }
    public void addData(View v){
        //check if field is empty
        if (validate()){
            String a=b.idEd.getText().toString();
            String aa=b.nameEd.getText().toString();
            String aaa=b.prefEd.getText().toString();
            @SuppressLint("StaticFieldLeak")
            class Addpeople extends AsyncTask<Void, Void, Void> {
                @Override
                protected Void doInBackground(Void... voids) {
                    DatabaseClient
                            .getInstance(AddActivity.this)
                            .getAppDatabase()
                            .customerDao()
                            .insert(new CustomerTable(a,aa,aaa));
                    return null;

                }

                @Override
                protected void onPostExecute(Void v) {
                    Toast.makeText(AddActivity.this, "Customer added successfully", Toast.LENGTH_SHORT).show();
                    b.prefEd.setText("");
                    b.nameEd.setText("");
                    b.idEd.setText("");
                }
            }

            Addpeople gh = new Addpeople();
            gh.execute();
        }
    }

    private boolean validate() {
        if (b.idEd.getText()!=null&&b.idEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the id correctly", Toast.LENGTH_LONG).show();
            return false;
        }else if (b.nameEd.getText()!=null&&b.nameEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the name correctly", Toast.LENGTH_LONG).show();
            return false;
        }else if (b.prefEd.getText()!=null&&b.prefEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the Preference correctly", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

}