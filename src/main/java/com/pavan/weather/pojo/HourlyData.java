package com.pavan.weather.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class HourlyData {
    @SerializedName("dt")
    private long date;

    @SerializedName("main")
    private HourSummary hourSummary;

    @SerializedName("weather")
    private HourlyWeather[] hourlyWeather;
}
