package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDiver(){
        if(driver== null){
            String browser=ConfigurationReader.getProperties("browser");
            switch (browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "microsoft Edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "remote-chrome":
                    try {
//                    ChromeOptions chromeOptions = new ChromeOptions();
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        URL gridUrl = new URL("http://52.91.254.112:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl, desiredCapabilities);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }
        return driver;
    }

    public static void closeDiver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
