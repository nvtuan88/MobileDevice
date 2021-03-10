package com.tuan.nguyenvantuan_weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Item> list;
    RecyclerView rvWeather;
    WeatherAdapter adapter;
    TextView tvPhrase, tvContent1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent1 = findViewById(R.id.tvContent1);
        tvPhrase = findViewById(R.id.tvPhrase);

        getData();
        list = new ArrayList<>();
        adapter = new WeatherAdapter(this, list);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvWeather = findViewById(R.id.weather);
        rvWeather.setLayoutManager(layoutManager);
        rvWeather.setAdapter(adapter);
    }

    private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service =retrofit.create(APIManager.class);
        service.apiGetListData().enqueue(new Callback<List<Item>>() {
             @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                list = response.body();
                getOneData(list.get(0));
                adapter.reloadData(list);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }

    public void getOneData(Item first){
        if(first != null){
            tvPhrase.setText(first.getIconPhrase());
            tvContent1.setText(first.getTemperature().getValue() + "°C");
        }
    }



}