package com.example.umbrella;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.umbrella.pojo.PojoResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView settingImage;
    int userZipCode =0;
    String userUnit;
    String Base_Url = "https://api.openweathermap.org/";
    TextView getCity, getTemp, getDescription;
    String tomorrowDate;
    String myDate;
    String myTime;
    String myIcon;
    String current_temp;
    String dateToday;
    String myTimeF;
    List<String> today_details = new ArrayList<>();

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_current_temp);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);

        settingImage = findViewById(R.id.iv_settings_btn);
        settingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                startActivityForResult(intent, 1);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        userZipCode = sharedPreferences.getInt("zip", 0);
        userUnit = sharedPreferences.getString("unit", "");
        if (userZipCode == 0) {
            Intent intent = new Intent(MainActivity.this, Search.class);
            startActivityForResult(intent, 1);
        } else {
            initializedRetrofit();
        }
    }
        public void initializedRetrofit(){
            String zipString = String.valueOf(userZipCode);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            WeatherApi weatherApi = retrofit.create(WeatherApi.class);
            weatherApi.getWeather(zipString).enqueue(new Callback<PojoResponse>() {
                @Override
                public void onResponse(Call<PojoResponse> call, Response<PojoResponse> response) {
                    if(response.body() !=null){
                        getCity = findViewById(R.id.tv_city);
                        getDescription = findViewById(R.id.tv_condition);
                        getTemp = findViewById(R.id.tv_temp);

                        LinearLayout topLayout = (LinearLayout) findViewById(R.id.ll_bar);

                        String dayOne;
                        dayOne = response.body().getwList().get(0).getDateText();
                        String arrayOne[] = dayOne.split("");

                        myDate = arrayOne[0];
                        myTime = (arrayOne[1].charAt(0)) + String.valueOf(arrayOne[1].charAt(1)) +":00";

                        String country = response.body().getCity().getCountry();
                        String city = response.body().getCity().getName();
                        getDescription.setText(response.body().getwList().get(0).getWeather().get(0).getDescription());

                        getCity.setText(city + ", " + country );
                        if (userUnit.trim().equals("Celsius") ){
                            String current_temp1 = String.valueOf(Math.round(((response.body().
                                    getwList().get(0).getMain().
                                    getTemp())-273.15))*100.00/100.00);
                            getTemp.setText((current_temp1)+" °C");
                        }
                        if (userUnit.trim().equals("Fahrenheit")){
                            String current_temp1 = String.valueOf(Math.round((((response.body().
                                    getwList().get(0).getMain().
                                    getTemp())-273.15))*9/5+32)*100.00/100.00);
                            getTemp.setText((current_temp1)+ " °F");
                        }

                        if (response.body().getwList().get(0).getMain().getTemp() < 288.0){
                            topLayout.setBackgroundColor(getResources().getColor(R.color.colorDBlue));

                        }
                        if (response.body().getwList().get(0).getMain().getTemp() > 303.0){
                            topLayout.setBackgroundColor(getResources().getColor(R.color.colorOrange));

                        }

                        if (response.body().getwList().get(0).getMain().getTemp() <= 303.0
                                && response.body().getwList().get(0).getMain().getTemp() >= 288.0){
                            topLayout.setBackgroundColor(getResources().getColor(R.color.colorMyAqua));
                        }

                        Calendar calendar = Calendar.getInstance();
                        Date today = calendar.getTime();
                        calendar.add(Calendar.DAY_OF_YEAR, 1);
                        Date tomorrow = calendar.getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        tomorrowDate = dateFormat.format(tomorrow);
                        dateToday = dateFormat.format(today);
                        calendar.add(Calendar.DAY_OF_YEAR, 2);
                        //Date tomorrow2 = calendar.getTime();
                        //String tomorrowDate2 = dateFormat.format(tomorrow2);


                }
                    
}

                @Override
                public void onFailure(Call<PojoResponse> call, Throwable t) {

                    });

                }
            }

