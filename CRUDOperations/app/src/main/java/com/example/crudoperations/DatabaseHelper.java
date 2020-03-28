package com.example.crudoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "automobile_Database";
    private static final int DB_VERSION = 1;
    public static final String automobile ="automobile";
    private static  String ID = "id";
    private static  String Name = "name";
    private static String Model = "model";
    private static String Variant = "variant";

//    String name,model,variant;
//    int id;

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE automobile(\n" +
                "    id int PRIMARY KEY,\n" +
                "    name varchar(100) NOT NULL,\n" +
                "    model varchar(100) NOT NULL,\n" +
                "    variant varchar(100) NOT NULL\n" +
                ");";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + automobile + "'");
        onCreate(db);
    }

    public long insertdata(String id,String name, String model, String variant){
        this.ID = id;
        this.Name = name;
        this.Model = model;
        this.Variant = variant;

        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(ID,id);
        values.put(Name,name);
        values.put(Model,model);
        values.put(Variant,variant);
        // insert row in students table
        long insert = db.insert(automobile, null, values);

        return insert;
    }

    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();

        String selectQuery = "SELECT  * FROM " + automobile;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(ID)));
                userModel.setName(c.getString(c.getColumnIndex(Name)));
                userModel.setModel(c.getString(c.getColumnIndex(Model)));
                userModel.setVariat(c.getString(c.getColumnIndex(Variant)));
                // adding to Students list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public int updateUser(int id, String name, String model,String variant) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(Name,name);
        values.put(Model,model);
        values.put(Variant,variant);

        // update row in students table base on students.is value
        return db.update(automobile, values, id + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteUSer(int id) {

        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(automobile, ID + " = ?", new String[]{String.valueOf(id)});
    }


}
