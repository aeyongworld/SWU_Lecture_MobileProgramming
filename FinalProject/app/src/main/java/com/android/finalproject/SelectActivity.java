package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

// 프로그램 제목 : 너의 원픽은?
// 학번: 2020111315 이름: 김동주
// 코드작성날짜 2022.12.15

public class SelectActivity extends AppCompatActivity {

    TextView text1,text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdo1, rdo2, rdo3, rdo4, rdo5;
    Button btnOK, btnNext;
    ImageView imgStar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setTitle("드라마 주인공 사진 보기~");            // 드라마의 주인공 사진을 볼 수 있다.

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdo1 = (RadioButton) findViewById(R.id.Rdo1);
        rdo2 = (RadioButton) findViewById(R.id.Rdo2);          // 5명의 드라마 주인공 이름을 라디오 버튼으로 설정하여,
        rdo3 = (RadioButton) findViewById(R.id.Rdo3);          // 라디오버튼을 클릭하고 버튼을 누르면 해당 주인공의 사진을 확인할 수 있다.
        rdo4 = (RadioButton) findViewById(R.id.Rdo4);
        rdo5 = (RadioButton) findViewById(R.id.Rdo5);

        btnOK = (Button) findViewById(R.id.BtnOK);
        btnNext = (Button) findViewById(R.id.btnNext2);
        imgStar = (ImageView) findViewById(R.id.ImgStar);

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.song1);

        final Switch switch1 = (Switch) findViewById(R.id.switch1);    // 싀위치를 켜서 사진을 보면서 배경음악을 들을 수 있다.
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch1.isChecked() == true)                       // 체크되있으면 재생되고
                    mPlayer.start();
                else
                    mPlayer.stop();                                   // 체크가 해제되면 음악이 꺼진다.
            }
        });

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {       // 체크박스를 체크해야 텍스트뷰, 라디오버튼, 버튼, 이미지뷰가 보여진다.

                if(chkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    imgStar.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    btnNext.setVisibility(View.INVISIBLE);
                    imgStar.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Rdo1:                                            // 각 라디오버튼이 체크되었을 때 버튼을 누르면 이미지를 보여준다.
                        imgStar.setImageResource(R.drawable.pro1);
                        break;
                    case R.id.Rdo2:
                        imgStar.setImageResource(R.drawable.pro2);
                        break;
                    case R.id.Rdo3:
                        imgStar.setImageResource(R.drawable.pro3);
                        break;
                    case R.id.Rdo4:
                        imgStar.setImageResource(R.drawable.pro4);
                        break;
                    case R.id.Rdo5:
                        imgStar.setImageResource(R.drawable.pro5);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "주인공 먼저 선택해요!", Toast.LENGTH_SHORT).show();      // 라디오버튼 체크를 안하고 버튼을 누르면 토스트 메시지가 보여진다.
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MusicActivity.class);       // 드라마 주인공 발매 앨범 확인 화면으로 넘어간다.
                startActivity(intent);
            }
        });

    }
}