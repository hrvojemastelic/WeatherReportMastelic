package com.example.weatherreport.models.ChildModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    @Expose
    public int all;

    public Clouds() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }


    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
