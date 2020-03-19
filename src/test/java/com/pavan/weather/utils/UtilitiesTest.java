package com.pavan.weather.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void getPropertiesValue()  {
        Assert.assertTrue(Utilities.getPropertiesValue("language").length()>0);
    }

    @Test
    public void getResourceBundle(){
        Assert.assertTrue(Utilities.getResourceBundle().getString("report.date.notify").length()>0);
    }
}