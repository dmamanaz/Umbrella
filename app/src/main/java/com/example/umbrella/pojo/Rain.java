package com.example.umbrella.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    @Expose
    private Double threeHr;

    public Double getThreeHr() {
        return threeHr;
    }

    public void setThreeHr(Double threeHr) {
        this.threeHr = threeHr;
    }
}
