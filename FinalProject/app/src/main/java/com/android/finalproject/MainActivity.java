package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가장 좋아하는 드라마 투표");

        final int voteCount[] = new int[9];
        for(int i=0; i<9; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.drama01, R.id.drama02, R.id.drama03, R.id.drama04, R.id.drama05, R.id.drama06, R.id.drama07, R.id.drama08, R.id.drama09};
        final String imgName[] = {"갯마을차차차", "또오해영", "사내맞선", "스물다섯스물하나", "스토브리그", "유미의세포들", "응답하라1988", "이상한변호사우영우", "청춘시대"};

        for(int i=0; i<imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총" + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });




    }
}