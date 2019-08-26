package com.example.weatherreport.models.ChildModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

   public class Coord {

    @SerializedName("lat")
    @Expose
    public double lat ;
    @SerializedName("lon")
    @Expose
    public double lon ;

    public Coord() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
