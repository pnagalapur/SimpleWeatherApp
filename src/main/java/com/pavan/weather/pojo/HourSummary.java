package com.pavan.weather.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class HourSummary {
    private Double temp;

    @SerializedName("feels_like")
    private Double feelsLike;

    @SerializedName("temp_min")
    private Double tempMin;

    @SerializedName("temp_max")
    private Double tempMax;
}
