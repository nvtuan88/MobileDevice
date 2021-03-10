package com.tuan.nguyenvantuan_weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=ZVQtvYqubEG1Nj8P7mme470pNEFmlwvu&language=vi-vn&metric=true")
    Call<List<Item>> apiGetListData();
}
