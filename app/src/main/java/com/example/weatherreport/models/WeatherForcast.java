package com.example.weatherreport.models;

import com.example.weatherreport.models.ChildModels.City;
import com.example.weatherreport.models.ChildModels.MyList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherForcast {

    @SerializedName("cod")
    @Expose
    public String cod ;
    @SerializedName("message")
    @Expose
    public double message ;
    @SerializedName("cnt")
    @Expose
    public int cnt ;
    @SerializedName("list")
    @Expose
    public ArrayList<MyList> list;
    @SerializedName("city")
    @Expose
    public City city ;


    public WeatherForcast() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<MyList> getList() {
        return list;
    }

    public void setList(ArrayList<MyList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "WeatherForcast{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}

