package com.tuan.nguyenvantuan_weather;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Item>listData;
    DateTime dt = new DateTime();
    ImageLink im = new ImageLink();


    public WeatherAdapter(Activity activity, List<Item> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    public void reloadData(List<Item> list) {
        listData = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = activity.getLayoutInflater().inflate(R.layout.item_wearther, parent, false);
    WeatherHolder holder = new WeatherHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item model = listData.get(position);
        WeatherHolder vh = (WeatherHolder) holder;

        vh.tvTime.setText(dt.convertTime(model.getDateTime()));
        vh.tvContent.setText(model.getTemperature().getValue() + "°C");
        Glide.with(activity).load(im.convertIcon(model.getWeatherIcon())).into(vh.ivCover);


    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class WeatherHolder extends RecyclerView.ViewHolder {
        TextView tvTime, tvContent;
        ImageView ivCover;

        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvContent = itemView.findViewById(R.id.tvContent);
            ivCover = itemView.findViewById(R.id.ivCover);
        }



    }




}
