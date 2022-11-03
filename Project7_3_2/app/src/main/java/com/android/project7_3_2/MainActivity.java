package com.android.project7_3_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.util.Log.i("Activity test", "onCreate()");

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottonnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                        return true;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                        return true;
                }

                return false;
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("Activity test", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("Activity test", "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("Activity test", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("Activity test", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("Activity test", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("Activity test", "onStop()");
    }
}