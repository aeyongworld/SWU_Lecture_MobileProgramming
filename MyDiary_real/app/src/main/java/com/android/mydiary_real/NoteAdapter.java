package com.android.mydiary_real;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> implements OnNoteItemClickListener {

    ArrayList<Note> items = new ArrayList<Note>();

    OnNoteItemClickListener listener;

    int layoutType = 0;

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.note_item, parent, false);

        return new ViewHolder(itemView, this, layoutType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note item = items.get(position);
        holder.setItem(item);
        holder.setLayoutType(layoutType);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnNoteItemClickListener listener) {
        this.listener = listener;
    }

    public void switchLayout(int position) {layoutType = position;}

    public void addItem(Note item) {
        items.add(item);
    }

    public void setItems(ArrayList<Note> items) {
        this.items = items;
    }

    public Note getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout1;
        LinearLayout layout2;

        ImageView moodImageView;
        ImageView moodImageView2;

        ImageView pictureExistsImageView;
        ImageView pictureImageView;

        ImageView weatherImageView;
        ImageView weatherImageView2;

        TextView contentsTextView;
        TextView contentsTextView2;

        TextView locationTextView;
        TextView locationTextView2;

        TextView dateTextView;
        TextView dateTextView2;

        public ViewHolder(@NonNull View itemView, OnNoteItemClickListener listener, int layoutType) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);
            layout2 = itemView.findViewById(R.id.layout2);

            moodImageView = itemView.findViewById(R.id.moodImageView);
            moodImageView2 = itemView.findViewById(R.id.moodImageView2);

            pictureExistsImageView = itemView.findViewById(R.id.pictureExistsImageView);
            pictureImageView = itemView.findViewById(R.id.pictureImageView);

            weatherImageView = itemView.findViewById(R.id.weatherImageView);
            weatherImageView2 = itemView.findViewById(R.id.weatherImageView2);

            contentsTextView = itemView.findViewById(R.id.contentsTextView);
            contentsTextView2 = itemView.findViewById(R.id.contentsTextView2);

            locationTextView = itemView.findViewById(R.id.locationTextView);
            locationTextView2 = itemView.findViewById(R.id.locationTextView2);

            dateTextView = itemView.findViewById(R.id.dateTextView);
            dateTextView2 = itemView.findViewById(R.id.dateTextView2);

            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int postion = getAdapterPosition();

                    if(listener != null) {
                        listener.onItemClick(ViewHolder.this, view, postion);
                    }
                }
            }); */

            setLayoutType(layoutType);
        }

        public void setLayoutType(int layoutType) {
            if(layoutType == 0) {
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            } else if (layoutType == 1) {
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
            }
        }


        public void setItem(Note item) {
            String mood = item.getMood();
            int moodIndex = Integer.parseInt(mood);
            setMoodImage(moodIndex);

            String picturePath = item.getPicture();
            if(picturePath != null && !picturePath.equals("")) {
                pictureExistsImageView.setVisibility(View.VISIBLE);
                pictureImageView.setVisibility(View.VISIBLE);
                pictureImageView.setImageURI(Uri.parse("file://" + picturePath));
            } else {
                pictureExistsImageView.setVisibility(View.GONE);
                pictureImageView.setVisibility(View.GONE);
                pictureImageView.setImageResource(R.drawable.noimagefound);
            }

            // set weather
            String weather = item.getWeather();
            int weatherIndex = Integer.parseInt(weather);
            setWeatherImage(weatherIndex);

            contentsTextView.setText(item.getContents());
            contentsTextView2.setText(item.getContents());

            locationTextView.setText(item.getAddress());
            locationTextView2.setText(item.getAddress());

            dateTextView.setText(item.getCreateDateStr());
            dateTextView2.setText(item.getCreateDateStr());
    }

        public void setWeatherImage(int weatherIndex) {
            switch (weatherIndex) {
                case 0:
                    weatherImageView.setImageResource(R.drawable.weather_1);
                    weatherImageView2.setImageResource(R.drawable.weather_1);
                    break;
                case 1:
                    weatherImageView.setImageResource(R.drawable.weather_2);
                    weatherImageView2.setImageResource(R.drawable.weather_2);
                    break;
                case 2:
                    weatherImageView.setImageResource(R.drawable.weather_3);
                    weatherImageView2.setImageResource(R.drawable.weather_3);
                    break;
                case 3:
                    weatherImageView.setImageResource(R.drawable.weather_4);
                    weatherImageView2.setImageResource(R.drawable.weather_4);
                    break;
                case 4:
                    weatherImageView.setImageResource(R.drawable.weather_5);
                    weatherImageView2.setImageResource(R.drawable.weather_5);
                    break;
                case 5:
                    weatherImageView.setImageResource(R.drawable.weather_6);
                    weatherImageView2.setImageResource(R.drawable.weather_6);
                    break;
                case 6:
                    weatherImageView.setImageResource(R.drawable.weather_7);
                    weatherImageView2.setImageResource(R.drawable.weather_7);
                    break;
                default:
                    weatherImageView.setImageResource(R.drawable.weather_1);
                    weatherImageView2.setImageResource(R.drawable.weather_1);
                    break;
            }
        }

        public void setMoodImage(int moodIndex) {
            switch (moodIndex) {
                case 0:
                    moodImageView.setImageResource(R.drawable.smile1_48);
                    moodImageView2.setImageResource(R.drawable.smile1_48);
                    break;
                case 1:
                    moodImageView.setImageResource(R.drawable.smile2_48);
                    moodImageView2.setImageResource(R.drawable.smile2_48);
                    break;
                case 2:
                    moodImageView.setImageResource(R.drawable.smile3_48);
                    moodImageView2.setImageResource(R.drawable.smile3_48);
                    break;
                case 3:
                    moodImageView.setImageResource(R.drawable.smile4_48);
                    moodImageView2.setImageResource(R.drawable.smile4_48);
                    break;
                case 4:
                    moodImageView.setImageResource(R.drawable.smile5_48);
                    moodImageView2.setImageResource(R.drawable.smile5_48);
                    break;
                default:
                    moodImageView.setImageResource(R.drawable.smile3_48);
                    moodImageView2.setImageResource(R.drawable.smile3_48);
                    break;

            }
        }


        }
    }


