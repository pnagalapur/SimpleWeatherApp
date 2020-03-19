package com.pavan.weather.api;

import com.pavan.weather.pojo.WeatherResult;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class OpenWeatherApiTest {

    @Test
    public void callApi() {
        WeatherResult weatherResult = OpenWeatherApi.callApi();
        Assert.assertEquals(weatherResult.getCode(),"200");


    }
}