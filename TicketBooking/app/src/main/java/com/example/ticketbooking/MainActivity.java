package com.example.ticketbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button add, update, view, delete;
    EditText id, name, title, movieDate;
    DataBaseHelperClass dataBaseHelperClass;
    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelperClass = new DataBaseHelperClass(this);
        id = findViewById(R.id.txtIID);
        name = findViewById(R.id.txtName);
        title = findViewById(R.id.txtTitle);
        movieDate = findViewById(R.id.txtDate);
        add = findViewById(R.id.btnAdd);
        update = findViewById(R.id.btnUpdate);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);

        AddViewer();
        UpdateDetails();
        ViewAll();
        DeleteViewer();

        final Calendar calendar = Calendar.getInstance();
        movieDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                movieDate.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void AddViewer(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dataBaseHelperClass.InsertData(
                        id.getText().toString(), name.getText().toString(), title.getText().toString(), movieDate.getText().toString()
                );
                if (isInserted) {

                    Toast.makeText(MainActivity.this, "Data Inserted !!!", Toast.LENGTH_LONG).show();
                    id.setText("");
                    name.setText("");
                    title.setText("");
                    movieDate.setText("");
                    id.setFocusable(true);
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Inserted !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void UpdateDetails(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = dataBaseHelperClass.UpdateData(
                        id.getText().toString(), name.getText().toString(), title.getText().toString(),  movieDate.getText().toString()
                );
                if (isUpdated) {
                    Toast.makeText(MainActivity.this, "Data Updated !!!", Toast.LENGTH_LONG).show();
                    id.setText("");
                    name.setText("");
                    title.setText("");
                    movieDate.setText("");
                    id.setFocusable(true);
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Updated !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ViewAll(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dataBaseHelperClass.getAllData();
                if(cursor.getCount() == 0){
                    showMessage("Error", "No record found ");
                    return;
                }else {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        stringBuffer.append("\nID : " + cursor.getString(0)+"\n");
                        stringBuffer.append("NAME : " + cursor.getString(1)+"\n");
                        stringBuffer.append("Title : " + cursor.getString(2)+"\n");
                        stringBuffer.append("Date : " + cursor.getString(3)+"\n");
                        stringBuffer.append("\n---------------------------------------\n");
                    }
                    showMessage("DATA : ",stringBuffer.toString());
                }
            }
        });
    }

    public void DeleteViewer(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                final EditText edittext = new EditText(MainActivity.this);
                alert.setMessage(id.getText().toString());
                alert.setTitle("Enter Your USER ID");
                alert.setView(edittext);
                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        long deleted = dataBaseHelperClass.DeleteData(edittext.getText().toString());
                        if (deleted > 0) {
                            Toast.makeText(MainActivity.this, "Data Deleted for user ID " , Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "User ID  not valid ", Toast.LENGTH_LONG).show();
                        }
                    }
                }).show();
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Ok clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
}
