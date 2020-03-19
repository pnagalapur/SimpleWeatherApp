package com.pavan.weather.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Utilities {

    private static Properties prop;
    private static String propFileName = "WeatherAppConfig.properties";
    private static ResourceBundle resourceBundle;
    private static Locale currentLocale;


    private static void initProperties(){
        try {
            if (prop == null) {
                prop = new Properties();
                InputStream inputStream = Utilities.class.getClassLoader().getResourceAsStream(propFileName);
                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getPropertiesValue(String Key) {
            initProperties();
            return prop.getProperty(Key);
    }

    public static ResourceBundle getResourceBundle(){

       if(resourceBundle==null){
           currentLocale = new Locale(getPropertiesValue("language"), getPropertiesValue("country"));
           resourceBundle = ResourceBundle.getBundle("MessagesBundle", currentLocale);
       }
       return resourceBundle;
    }

    public static Map<String, Object> getMultiProp(String keyPrefix){
        initProperties();
        Set<Object> keys = prop.keySet();
        HashMap<String,Object> keysMatching =new HashMap<>();

        keys.forEach(e->{
            if(e instanceof String){
                if(((String) e).startsWith(keyPrefix)){
                    keysMatching.put(((String) e).replace(keyPrefix,""),getPropertiesValue((String)e));
                }
            }
        });


        return keysMatching;
    }

}
