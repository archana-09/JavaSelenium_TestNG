package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProp {
    public static void main (String arg[]) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:/Users/archanas/Documents/Test_selenium_POC/src/test/java/config/config.properties");
        prop.load(ip);
    }
}
