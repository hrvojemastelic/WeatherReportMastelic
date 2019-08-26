package com.example.weatherreport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainModel {
    @SerializedName("date_time")
    @Expose
    private  String date_time;

    @SerializedName("temp")
    @Expose
    private  double temp;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("description")
    @Expose
    private String description;

    public  MainModel(){

    }
    public MainModel(String date_time, double temp,String img,String description) {
        this.date_time=date_time;
        this.img=img;
        this.temp=temp;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }


}
