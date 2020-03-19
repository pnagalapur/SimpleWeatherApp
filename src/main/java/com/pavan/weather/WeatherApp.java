package com.pavan.weather;

import com.pavan.weather.display.WeatherDisplay;
import com.pavan.weather.observer.WeatherWatcher;
import com.pavan.weather.utils.Utilities;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: Pavan Nagalapur
 *
 */
public class WeatherApp
{
    public static void main( String[] args )
    {

        final WeatherWatcher weatherWatcher=new WeatherWatcher();
        final WeatherDisplay weatherDisplay=new WeatherDisplay();

        weatherWatcher.addObserver(weatherDisplay);

        Runnable WeatherWatcherRunnable = () -> {
            Thread thread = new Thread(weatherWatcher);
            thread.start();

        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(WeatherWatcherRunnable, 0, Long.parseLong(Utilities.getPropertiesValue("weather.api.call.every.x.sec")), TimeUnit.SECONDS);

    }
}
