package com.android.project8_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    Integer[] posterID;

    String[] posterTitle = { "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3", "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
            "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3", "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
            "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3", "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
            "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3", "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨"};

    RecyclerViewAdapter(Context context, Integer[] posterID) {
        this.context = context;
        this.posterID = posterID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivPoster1.setImageResource(posterID[position]);

        final int pos = position;
        holder.ivPoster1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialogView = (View) View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster2);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setTitle(posterTitle[pos]);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return posterID.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPoster1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster1 = itemView.findViewById(R.id.ivPoster1);
        }
    }


}
