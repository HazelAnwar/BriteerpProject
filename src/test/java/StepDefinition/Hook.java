package StepDefinition;

import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    @Before
    public void setup(){
        System.out.println("#####################");
        System.out.println("Test setup!");
        Driver.getDriver().manage().window().maximize();
    }
   @After
    public void teardown(Scenario scenario){
        //if test failed - do this
        if(scenario.isFailed()){
            System.out.println("Test failed!");
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }else{
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        System.out.println("##############################");
//        Driver.getDriver().close(); // Driver.closeDriver();
    }

}
