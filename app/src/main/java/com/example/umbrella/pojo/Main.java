package com.example.umbrella.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private Float temp;
    @SerializedName("temp_min")
    @Expose
    private Double minTemp;
    @SerializedName("temp_max")
    @Expose
    private Double maxTemp;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("sea_level")
    @Expose
    private Double seaLvl;
    @SerializedName("grnd_level")
    @Expose
    private Double groundLvl;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("temp_kf")
    @Expose
    private Double tempKf;

    public Float getTemp() {
        return temp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getSeaLvl() {
        return seaLvl;
    }

    public Double getGroundLvl() {
        return groundLvl;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getTempKf() {
        return tempKf;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setSeaLvl(Double seaLvl) {
        this.seaLvl = seaLvl;
    }

    public void setGroundLvl(Double groundLvl) {
        this.groundLvl = groundLvl;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setTempKf(Double tempKf) {
        this.tempKf = tempKf;
    }
}
