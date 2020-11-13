package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties=new Properties();

    static {
        try {
            FileInputStream file=new FileInputStream("Configuration.Properties");

            properties.load(file);

            file.close();

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Properties file notFound.");
        }

    }
    public static String getProperties(String keyWord){
        return properties.getProperty(keyWord);
    }
}
