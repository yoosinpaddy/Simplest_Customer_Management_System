package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.humaid.abdulla.databinding.ActivityDeleteBinding;
import com.humaid.abdulla.databinding.ActivityDisplayBinding;
import com.humaid.abdulla.room.config.DatabaseClient;

public class DeleteActivity extends AppCompatActivity {
    ActivityDeleteBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_delete);
        //delete when button is clicked
        b.deleteCustomer.setOnClickListener(this::deleteCustomer);
    }
    public void deleteCustomer(View v){
        //check if field is empty
        if (validate()){
            String idToDelete=b.idEd.getText().toString();
            @SuppressLint("StaticFieldLeak")
            class DeleteCustomer extends AsyncTask<Void, Void, Void> {
                @Override
                protected Void doInBackground(Void... voids) {
                    //Query database to delete
                     DatabaseClient
                            .getInstance(DeleteActivity.this)
                            .getAppDatabase()
                            .customerDao()
                            .hasDeleted(idToDelete);
                    return null;

                }

                @Override
                protected void onPostExecute(Void v) {
                    //Get Database response
                        Toast.makeText(DeleteActivity.this, "Customer Deleted successfully", Toast.LENGTH_SHORT).show();
                        b.idEd.setText("");
                }
            }

            DeleteCustomer gh = new DeleteCustomer();
            gh.execute();

        }
    }

    private boolean validate() {
        if (b.idEd.getText()!=null&&b.idEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the id correctly", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
}