package com.example.canvasruntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));

    }

    public class CustomView extends View {

        final Paint paint=new Paint();

        public CustomView(Context context) {
            super(context);

            paint.setColor(Color.BLUE);
            paint.setTextSize(80);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawText("Welcome",300,400,paint);
            setBackgroundColor(Color.BLACK);

            Picture pic=new Picture(,600,500);
            invalidate();
        }
    }
}
