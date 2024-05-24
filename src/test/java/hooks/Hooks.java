package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.ConfigReader;
import utilities.Driver;


import static utilities.Driver.getDriver;


public class Hooks {

    @Before("@web")
    public void webSetUpScenarios() {
  System.out.println("Before Metotu");
 Driver. getDriver().get(ConfigReader.getProperty("url"));


    }



    @After
    public static void tearDownScenarios(Scenario scenario) {
        System.out.println("After Metotu");
        // Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            // ekran goruntusu file tipi ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

            // Driver.closeDriver(); // Burasi tarayici kapatir
        }
    }
}
