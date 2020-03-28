package com.example.ticketbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBaseHelperClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ticketbook";
    public static final String TABLE_NAME = "movie_table";
    public static final String COL_ID = "mid";
    public static final String COL_NAME = "name";
    public static final String COL_TITLE = "mtitle";
    public static final String COL_DATE = "rdate";

    public DataBaseHelperClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(mid varchar(30) primary key, name text, mtitle text, rdate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String mid, String name, String mtitle, String rdate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ID, mid);
        cv.put(COL_NAME, name);
        cv.put(COL_TITLE, mtitle);
        cv.put(COL_DATE, rdate);
        long inserted = db.insert(TABLE_NAME, null, cv);
        if (inserted == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateData(String mid, String name, String mtitle, String rdate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID,mid);
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_TITLE,mtitle);
        contentValues.put(COL_DATE,rdate);
        db.update(TABLE_NAME,contentValues," mid = ? ",new String[] { mid });
        return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    public Integer DeleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME," mid = ? ", new String[] { id });
    }

}
