package com.pavan.weather.observer;

import com.pavan.weather.api.OpenWeatherApi;
import com.pavan.weather.pojo.WeatherResult;
import com.pavan.weather.utils.Utilities;

import java.util.Observable;

public class WeatherWatcher extends Observable implements Runnable {
    private static WeatherResult weatherResultOld=null;
    private WeatherResult weatherResultNew;
    @Override
    public void run(){

        try{
             weatherResultNew=OpenWeatherApi.callApi();
            if(weatherResultNew.getCode().equalsIgnoreCase("200")){

                if(!weatherResultNew.equals(weatherResultOld)) {
                    weatherResultOld=weatherResultNew;
                    setChanged();
                    notifyObservers(weatherResultNew);
                }
            }else{

                throw  new Exception(Utilities.getResourceBundle().getString("api.exception.msg"));
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
