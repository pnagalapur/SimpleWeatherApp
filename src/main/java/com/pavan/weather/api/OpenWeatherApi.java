package com.pavan.weather.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pavan.weather.pojo.WeatherResult;
import com.pavan.weather.utils.Utilities;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.Map;

public class OpenWeatherApi {

    public static WeatherResult callApi(){
        GetRequest getRequest = Unirest.get(Utilities.getPropertiesValue("api.url"));

        getRequest.queryString( Utilities.getMultiProp("api.filter."));

        HttpResponse<String> stringHttpResponse = getRequest.asString();

        JsonParser parser =new JsonParser();
        JsonElement parse = parser.parse(stringHttpResponse.getBody());

        return  new Gson().fromJson(parse,WeatherResult.class);
    }

}
