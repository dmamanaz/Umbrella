package com.example.umbrella;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    private Context context;
    private List<List<String>> items;

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder

    {

        ImageView currentImage;
        TextView currentTime;
        TextView currentTemp;
        LinearLayoutCompat cardLayout;



        public CustomViewHolder(View itemView) {
            super(itemView);
            cardLayout =  itemView.findViewById(R.id.details_today);
            currentImage = itemView.findViewById(R.id.today_icon);
            currentTemp = itemView.findViewById(R.id.today_temp);
            currentTime = itemView.findViewById(R.id.today_time);
        }
    }

}
