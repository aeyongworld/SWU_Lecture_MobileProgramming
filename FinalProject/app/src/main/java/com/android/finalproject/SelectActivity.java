package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        setTitle("드라마 주인공 사진 보기~");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdo1 = (RadioButton) findViewById(R.id.Rdo1);
        rdo2 = (RadioButton) findViewById(R.id.Rdo2);
        rdo3 = (RadioButton) findViewById(R.id.Rdo3);
        rdo4 = (RadioButton) findViewById(R.id.Rdo4);
        rdo5 = (RadioButton) findViewById(R.id.Rdo5);

        btnOK = (Button) findViewById(R.id.BtnOK);
        btnNext = (Button) findViewById(R.id.btnNext2);
        imgStar = (ImageView) findViewById(R.id.ImgStar);


        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

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
                    case R.id.Rdo1:
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
                        Toast.makeText(getApplicationContext(), "주인공 먼저 선택해요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MusicActivity.class);
                startActivity(intent);
            }
        });

    }
}