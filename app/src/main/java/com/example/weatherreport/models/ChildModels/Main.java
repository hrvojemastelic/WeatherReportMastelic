package com.example.weatherreport.models.ChildModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    @Expose
    public double temp ;
    @SerializedName("temp_min")
    @Expose
    public double temp_min ;
    @SerializedName("temp_max")
    @Expose
    public double temp_max ;
    @SerializedName("pressure")
    @Expose
    public double pressure ;
    @SerializedName("sea_level")
    @Expose
    public double sea_level ;
    @SerializedName("grnd_level")
    @Expose
    public double grnd_level ;
    @SerializedName("humidity")
    @Expose
    public double humidity ;
    @SerializedName("temp_kf")
    @Expose
    public double temp_kf ;


    public  Main(){

    }
    public double getTemp() {
        return temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public double getSea_level() {
        return sea_level;
    }

    public double getGrnd_level() {
        return grnd_level;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    public void setGrnd_level(double grnd_level) {
        this.grnd_level = grnd_level;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_kf(int temp_kf) {
        this.temp_kf = temp_kf;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", sea_level=" + sea_level +
                ", grnd_level=" + grnd_level +
                ", humidity=" + humidity +
                ", temp_kf=" + temp_kf +
                '}';
    }
}
