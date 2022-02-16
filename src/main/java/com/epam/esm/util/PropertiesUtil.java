package com.epam.esm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Util class for loading properties from application.properties
public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        try(InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(resourceAsStream);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

}
