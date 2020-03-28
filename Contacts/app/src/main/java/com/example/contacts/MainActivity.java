package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alist = new ArrayList<>();
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ContentResolver cr = getContentResolver();
        Cursor curs = cr.query(ContactsContract.Contacts.CONTENT_URI, null, ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1", null,
                "UPPER(" + ContactsContract.Contacts.DISPLAY_NAME + ")ASC");

        if (curs.getCount() > 0) {
            while (curs.moveToNext()) {
                String email;
                String id = curs.getString(curs.getColumnIndex(ContactsContract.Contacts._ID));
                String name = curs.getString(curs.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(curs.getString(curs.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[]{id}, null);
                    Cursor pCur1 = cr.query(
                            ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                            new String[]{id}, null);

                    while (pCur.moveToNext()) {
                        String phnNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        alist.add("Name: " + name + "\nPhone No: " + phnNo);
                        if (pCur1.moveToNext()) {
                            email = pCur1.getString(pCur1.getColumnIndex((ContactsContract.CommonDataKinds.Email.DATA)));
                            Set<String> hash_Set = new HashSet<>();
                            hash_Set.add(name);
                            System.out.println(hash_Set);
                            alist.add("Name :" + hash_Set + "\n Phone no:" + phnNo + "\nEmail id :" + email);
                        } else {
                            Set<String> hash_Set = new HashSet<>();
                            hash_Set.add(name);
                            System.out.println(hash_Set);
                            alist.add("Name :" + hash_Set + "\n Phone no:" + phnNo);
                        }
                    }
                    pCur.close();
                    pCur1.close();
                }
            }
        }
        lv =(ListView)findViewById(R.id.list1);
        alist = new ArrayList<String>(new LinkedHashSet<String>(alist));
        ArrayAdapter<String> adt=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alist);
        lv.setAdapter(adt);
    }
}
