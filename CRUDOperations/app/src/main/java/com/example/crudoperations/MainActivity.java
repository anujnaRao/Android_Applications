package com.example.crudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UserModel userModel;
    private EditText id,name,model,variant;
    private Button btnupdate, btndelete,btncreate, btnread;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        userModel = (UserModel) intent.getSerializableExtra("user");

        databaseHelper = new DatabaseHelper(this);

        id = findViewById(R.id.etID);
        name = findViewById(R.id.etName);
        model = findViewById(R.id.etModel);
        variant = findViewById(R.id.etVariant);

        btndelete = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btncreate = findViewById(R.id.btnCreate);
        btnread = findViewById(R.id.btnRead);

        id.setText(userModel.getId());
        name.setText(userModel.getName());
        model.setText(userModel.getModel());
        variant.setText(userModel.getVariat());

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.insertdata(id.getText().toString(), name.getText().toString(),model.getText().toString(),variant.getText().toString());
                id.setText("");
                model.setText("");
                name.setText("");
                variant.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();

            }
        });

        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetDetails.class);
                startActivity(intent);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateUser(userModel.getId(),name.getText().toString(),model.getText().toString(),variant.getText().toString());
                Toast.makeText(MainActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(userModel.getId());
                Toast.makeText(MainActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
            }
        });


    }
}
