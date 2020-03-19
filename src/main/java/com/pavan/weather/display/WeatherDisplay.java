package com.pavan.weather.display;

import com.pavan.weather.pojo.HourlyData;
import com.pavan.weather.pojo.HourlyWeather;
import com.pavan.weather.pojo.WeatherResult;
import com.pavan.weather.utils.Utilities;

import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WeatherDisplay implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        LocalDate localDate;
        ArrayList<String> tempReached=new ArrayList<>();
        ArrayList<String> sunnyWeather=new ArrayList<>();
            if(arg instanceof WeatherResult){
                HourlyData[] listOfHourlyData = ((WeatherResult) arg).getListOfHourlyData();
                for (HourlyData hourlyData : listOfHourlyData) {
                    Date date = new Date(hourlyData.getDate() * 1000);
                     localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    String dateFormatted=localDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

                    if(hourlyData.getHourSummary().getTemp()>Double.parseDouble(Utilities.getPropertiesValue("max.temp"))){
                        if(!tempReached.contains(dateFormatted)){
                            tempReached.add(dateFormatted);
                        }
                        for (HourlyWeather hourlyWeather : hourlyData.getHourlyWeather()) {
                            if(hourlyWeather.getWeatherType().equalsIgnoreCase(Utilities.getPropertiesValue("weather.type"))){
                                if(!sunnyWeather.contains(dateFormatted)){
                                    sunnyWeather.add(dateFormatted);
                                }
                            }
                        }
                    }

                }

            }
        try {
            ResourceBundle resourceBundle = Utilities.getResourceBundle();

            System.out.println(MessageFormat.format(resourceBundle.getString("report.date.notify"), LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(Utilities.getPropertiesValue("weather.print.datetime.format")))));
            System.out.println(MessageFormat.format(resourceBundle.getString("temp.num.days"), tempReached.size()));
            System.out.println(MessageFormat.format(resourceBundle.getString("weather.type.days"), sunnyWeather.size()));
            System.out.println(resourceBundle.getString("after.display.msg"));
        }
        catch (Exception e){
            System.out.println("Resource bundle seems to have a issue please check that");
            e.printStackTrace();
        }
    }
}
