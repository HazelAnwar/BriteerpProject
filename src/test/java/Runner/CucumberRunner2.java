package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/sales/customer",
        glue = "StepDefinition",
        tags ="" ,
        dryRun = true,
        publish = true,plugin = "html:target/report.html"

)

public class CucumberRunner2 {

}
