package com.android.project6_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("액티비티 테스트 예제");
        android.util.Log.i("액티비티 테스트", "onCreate()");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        Button btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        android.util.Log.i("액티비티 테스트","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        android.util.Log.i("액티비티 테스트","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        android.util.Log.i("액티비티 테스트","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        android.util.Log.i("액티비티 테스트","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        android.util.Log.i("액티비티 테스트","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        android.util.Log.i("액티비티 테스트","onRestart()");
    }
}