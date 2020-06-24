package com.humaid.abdulla;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteActivity extends AppCompatActivity {
    Button deleteCustomer;
    EditText idEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteCustomer=findViewById(R.id.deleteCustomer);
        idEd=findViewById(R.id.idEd);
        
        //delete when button is clicked
        deleteCustomer.setOnClickListener(this::deleteCustomer);
    }
    public void deleteCustomer(View v){
        //check if field is empty
        if (validate()){
            String idToDelete=idEd.getText().toString();
            String sql="DELETE from people where id="+idToDelete+";";
            SQLiteDatabase db =openOrCreateDatabase("user",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS customers ( id  text NOT NULL, name text NOT NULL,  preference text NOT NULL);");
            db.execSQL(sql);
            //Get Database response
            Toast.makeText(DeleteActivity.this, "Customer Deleted successfully", Toast.LENGTH_SHORT).show();
            idEd.setText("");

        }
    }

    private boolean validate() {
        if (idEd.getText()!=null&&idEd.getText().toString().length()<2){
            Toast.makeText(this, "Please fill the id correctly", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
}