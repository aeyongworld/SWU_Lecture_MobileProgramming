package com.android.viewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv1, tv2, tv3;

        tv1 = findViewById(R.id.textview1);
        tv2 = findViewById(R.id.textview2);
        tv3 = findViewById(R.id.textview3);

        tv1.setText("안녕하세요?");
        tv1.setTextColor(Color.BLUE);

        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);

        tv3.setText("안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?안녕하세요?");
        tv3.setSingleLine();

    }
}