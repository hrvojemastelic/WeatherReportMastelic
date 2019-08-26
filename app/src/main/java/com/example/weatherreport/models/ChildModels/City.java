package com.example.weatherreport.models.ChildModels;

import com.example.weatherreport.models.ChildModels.Coord;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    @Expose
    public int id ;
    @SerializedName("name")
    @Expose
    public String name ;
    @SerializedName("coord")
    @Expose
    public Coord coord ;
    @SerializedName("country")
    @Expose
    public String country ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                '}';
    }
}
