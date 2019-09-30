package com.example.umbrella;

import com.example.umbrella.pojo.PojoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Api key 0eb54733dad4c8b7faf85e5a04f91ba8
public interface WeatherApi {
    @GET("data/2.5/forecast?,us&appid=0eb54733dad4c8b7faf85e5a04f91ba8")
    Call<PojoResponse> getWeather(@Query("zip")String myZip);
}
