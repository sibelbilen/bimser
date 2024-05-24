package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {
        "pretty",
        "html:target/htmlReport/cucumberHooks.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/htmlReport/cucumber.xml",
        "rerun:target/failed_scenario.txt",
// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}, features = "src/test/resources/features",
        glue = {
        "stepDefs",
        "hooks"},
        tags = "@negatif", dryRun =false )

public class Runner {
}