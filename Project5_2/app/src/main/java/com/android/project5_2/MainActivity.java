package com.android.project5_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2, button3;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();

        if(v == button1) {
            menu.setHeaderTitle("배경색 변경");

            mInflater.inflate(R.menu.menu1, menu);

        }
        if(v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] versionArray = new String[] {"Q(10)", "R(11)", "S(12)"};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목");
//                dlg.setMessage("내용");
                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button3.setText(versionArray[i]);
                    }
                });
                dlg.setPositiveButton("확인",null);
                dlg.show();
            }
        });
    }
}