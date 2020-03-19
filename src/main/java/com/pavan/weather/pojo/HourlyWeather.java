package com.pavan.weather.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class HourlyWeather {
    @SerializedName("main") private String weatherType;
}
