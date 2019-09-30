package com.example.umbrella.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoResponse {
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cnt")
    @Expose
    private String cnt;
    @SerializedName("list")
    @Expose
    private List<List<PojoResponse>> wList = null;
    @SerializedName("city")
    @Expose
    private String city;

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public List<List<PojoResponse>> getwList() {
        return wList;
    }

    public String getCity() {
        return city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public void setwList(List<List<PojoResponse>> wList) {
        this.wList = wList;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
