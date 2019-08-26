package com.example.weatherreport.models.ChildModels;

import com.example.weatherreport.models.ChildModels.ChildModelMylist.Weather;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyList {
    @SerializedName("weather")
    @Expose
    List<Weather> weather ;
    @SerializedName("clouds")
    @Expose
    public Clouds clouds;
    @SerializedName("wind")
    @Expose
    public Wind wind ;
    @SerializedName("rain")
    @Expose
    public Rain rain ;
    @SerializedName("sys")
    @Expose
    public Sys sys ;
    @SerializedName("dt_txt")
    @Expose
    public String dt_txt;
    @SerializedName("dtt")
    @Expose
    int dt ;
    @SerializedName("main")
    @Expose
    Main main ;

    public MyList() {
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", rain=" + rain +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                ", dt=" + dt +
                ", main=" + main +
                '}';
    }
}
