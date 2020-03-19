package com.pavan.weather;

import com.pavan.weather.display.WeatherDisplay;
import com.pavan.weather.observer.WeatherWatcher;
import com.pavan.weather.utils.Utilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class WeatherAppTest {

    private final ByteArrayOutputStream outRedirect = new ByteArrayOutputStream();
    private final PrintStream outActual = System.out;

    @Before
    public void setupRedirects(){
        System.setOut(new PrintStream(outRedirect));
    }

    @After
    public void revertChanges(){
        System.setOut(outActual);
    }

    @Test
    public void testWatcher(){

        final WeatherWatcher weatherWatcher=new WeatherWatcher();
        final WeatherDisplay weatherDisplay=new WeatherDisplay();

        weatherWatcher.addObserver(weatherDisplay);
        weatherWatcher.run();
        assertTrue(outRedirect.toString().contains(Utilities.getResourceBundle().getString("after.display.msg")));
    }

}