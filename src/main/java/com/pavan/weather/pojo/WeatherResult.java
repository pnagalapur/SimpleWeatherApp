package com.pavan.weather.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WeatherResult {

@SerializedName("cod")
private String code;

@SerializedName("list")
private HourlyData[] listOfHourlyData;

}

