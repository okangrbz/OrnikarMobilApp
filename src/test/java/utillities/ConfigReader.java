package utillities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;
    static {
        String path = "configuration.properties";
        try{
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        }catch (Exception e){
            System.out.println("not file.");
        }
    }
    //will return value from config
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
