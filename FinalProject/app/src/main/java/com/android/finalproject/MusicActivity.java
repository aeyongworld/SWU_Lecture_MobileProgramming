package com.android.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

// 프로그램 제목 : 너의 원픽은?
// 학번: 2020111315 이름: 김동주
// 코드작성날짜 2022.12.15

public class MusicActivity extends AppCompatActivity {

    View dialogView;
    LinearLayout baseLayout;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {           // 옵션 메뉴를 만들어 주었다.
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {       // 옵션메뉴의 각각 아이템을 클릭하면 지정한 배경색으로 바뀐다.
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                      // 해당되는 버튼을 클릭하면
        setContentView(R.layout.activity_music);                                 // 주인공들이 발매한 앨범 정보를 대화상자로 확인할 수 있다.
        setTitle("앨범정보 확인");
        final Button button01 = (Button) findViewById(R.id.btn01);
        final Button button02 = (Button) findViewById(R.id.btn02);
        final Button button03 = (Button) findViewById(R.id.btn03);
        final Button button04 = (Button) findViewById(R.id.btn04);
        final Button button05 = (Button) findViewById(R.id.btn05);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MusicActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MusicActivity.this);
                dlg.setTitle("앨범 정보");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MusicActivity.this, R.layout.dialog2, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MusicActivity.this);
                dlg.setTitle("앨범 정보");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MusicActivity.this, R.layout.dialog3, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MusicActivity.this);
                dlg.setTitle("앨범 정보");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MusicActivity.this, R.layout.dialog4, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MusicActivity.this);
                dlg.setTitle("앨범 정보");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);      // 돌아가기 버튼을 누르면 처음 드라마 투표로 돌아갈 수 있다.
                startActivity(intent);
            }
        });


    }
}