package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,sub,mul,div,clear;
    EditText num1,num2,op;
    Double n1,n2,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1= (EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        op=(EditText)findViewById(R.id.output);

        add=(Button)findViewById(R.id.btnp);
        sub=(Button)findViewById(R.id.btns);
        mul=(Button)findViewById(R.id.btnm);
        div=(Button)findViewById(R.id.btnd);
        clear=(Button)findViewById(R.id.btnclear);

        num1.setInputType(InputType.TYPE_CLASS_NUMBER);
        num2.setInputType(InputType.TYPE_CLASS_NUMBER);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((num1.getText().length()>0) && (num2.getText().length()>0) )
                {
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());

                    res=n1+n2;
                    op.setText(Double.toString(res));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                }

            }

        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((num1.getText().length()>0) && (num2.getText().length()>0) )
                {
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());

                    res=n1-n2;
                    op.setText(Double.toString(res));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                }

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((num1.getText().length()>0) && (num2.getText().length()>0) )
                {
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());

                    res=n1*n2;
                    op.setText(Double.toString(res));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((num1.getText().length()>0) && (num2.getText().length()>0) )
                {
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());

                    res=n1/n2;
                    op.setText(Double.toString(res));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                }

            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num1.setText("");
                num2.setText("");
                op.setText("");
                num1.requestFocus();

            }
        });

    }
}
