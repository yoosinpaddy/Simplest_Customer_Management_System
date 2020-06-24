package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Button add;
    EditText idEd;
    EditText nameEd;
    EditText prefEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add=findViewById(R.id.add);
        idEd=findViewById(R.id.idEd);
        nameEd=findViewById(R.id.nameEd);
        prefEd=findViewById(R.id.prefEd);
        //add data when add button is clicked
        add.setOnClickListener(this::addData);
    }
    public void addData(View v){
        //check if field is empty
        if (validate()){
            String a=idEd.getText().toString();
            String aa=nameEd.getText().toString();
            String aaa=prefEd.getText().toString();
            String sql="INSERT INTO people (id,name,preference) VALUES('"+a+"','"+aa+"','"+aaa+"');";
            SQLiteDatabase db =openOrCreateDatabase("user",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS people ( id  text NOT NULL, name text NOT NULL,  preference text NOT NULL);");
            db.execSQL(sql);
            Toast.makeText(AddActivity.this, "Customer added successfully", Toast.LENGTH_SHORT).show();
            prefEd.setText("");
            nameEd.setText("");
            idEd.setText("");
        }
    }

    private boolean validate() {
        if (idEd.getText()!=null&&idEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the id correctly", Toast.LENGTH_LONG).show();
            return false;
        }else if (nameEd.getText()!=null&&nameEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the name correctly", Toast.LENGTH_LONG).show();
            return false;
        }else if (prefEd.getText()!=null&&prefEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the Preference correctly", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

}