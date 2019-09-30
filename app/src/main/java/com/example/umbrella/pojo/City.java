package com.example.umbrella.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName(" name")
    @Expose
    private Integer name;
    @SerializedName("icoord")
    @Expose
    private Integer coord;
    @SerializedName("country")
    @Expose
    private Integer country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getCoord() {
        return coord;
    }

    public void setCoord(Integer coord) {
        this.coord = coord;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }
}
