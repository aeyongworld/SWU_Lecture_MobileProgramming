package com.android.project7_1;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        menuFragment = MenuFragment.newInstance();



        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
                        Toast.makeText(getApplicationContext(), "첫번째 탭 선택됨", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
                        return true;
                }
            }
        });
    }

//    public void onFragmentChanged(int i) {
//        if(i == 0) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
//        }
//        else if(i == 1) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
//       }
//    }
}