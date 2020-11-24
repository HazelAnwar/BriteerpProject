package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature/Customer",
        glue = "StepDefinition",
        tags ="" ,
        dryRun = false,
        publish = true,plugin = "html:target/report.html"

)

public class CucumberRunner2 {

}
