package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
       Singleton Pattern: Tekli kullanım kalıbı.
           Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
           Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
       private access modifire kullanarak bir constructor oluştururuz
        */
    public Driver() {
    }
    /*
          Driver class'ındaki temel mantık extends yöntemiyle değil yani ReusableMethods class'ına extent etmek yerine
      Driver class'ından static methodlar kullanarak driver oluştururuz. Static olduğu için class ismi ile
      her yerden methoda ulaşabileceğiz.
       */
    public static WebDriver driver;

    public static WebDriver getDriver() {
        /*
         * Driver'i her cagirdiginda yeni bir pencere acilmasinin onune gecmek icin
         * if blogu icinde Eger driver'a deger atanmamissa(driver doluysa) deger ata,
         * Eger deger atanmissa Driver'i ayni
         * sayfada RETURN et. Bunun sadece yapmamiz gereken if(driver==null) kullanmak
         */
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("--headless");
                    //options.addArguments("--disable-gpu");
                    //options.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(options);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                default:

                    // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    // setHeadless =browser acilmasa bile sen testleri calistir calistir
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {// Driver'a deger atanmisssa
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {// Driver'a deger atanmisssa
            driver.quit();
            driver = null;
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
}