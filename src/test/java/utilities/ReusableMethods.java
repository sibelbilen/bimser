package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utilities.Driver.getDriver;

public class ReusableMethods {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    // HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Bu metot Action class kullanarak bir webelementin ustune gidip bekler
     * 
     * @param element yerine webelement'in locate koyulmalidir
     */
    public static void hover(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Alert ACCEPT
    public static void alertAccept() {
        getDriver().switchTo().alert().accept();
    }

    // Alert DISMISS
    public static void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    // Alert getText()
    public static void alertText() {
        getDriver().switchTo().alert().getText();
    }

    // Alert promptBox
    public static void alertprompt(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    // DropDown VisibleText
    /*
     * Select select2 = new Select(gun);
     * select2.selectByVisibleText("7");
     * 
     * //ddmVisibleText(gun,"7"); --> Yukaridaki kullanim yerine sadece method ile
     * handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    // DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    // DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    // SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    // SwitchToWindow2
    public static void window(int sayi) {
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[sayi].toString());
    }

    // EXPLICIT WAIT METHODS
    // Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // VisibleElementLocator Wait sana verdigim element gozukene kadar bekle
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // VisibleElementLocator Wait sana verdigim locete gozukene kadar bekle
    public static WebElement waitForVisibility(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // VisibleElementLocator Wait sana verdigim elemnt tiklanabilir olduguna kadar
    // bekle
    public static WebElement waitForClickablility(By element, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // VisibleElementLocator Wait sana verdigim locete tiklanabilir olana kadar
    // bekle
    public static WebElement waitForVisibilityy(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Tum Sayfa ScreenShot
    public static void tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + name + ".png";
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ExtentReport
    public static void extentReport() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        // Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "sibel");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }

    /**
     * bu metot ile JS yolu string olarak verilen elementi JavascriptExecutor
     * kullanarak tiklayabilirim
     */
    public static void clickJSElementWithJavaScript(String javascriptYolu) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) jse.executeScript("return " + javascriptYolu + "");
        jse.executeScript("arguments[0].click();", webElement);
    }

    // WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    // Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    // JS Scroll element gozukene kadar asagi in
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * JavaScript ile webelement olusturma
     *
     * @param javascriptYolu internet sitesinden sag klik ile JS yolunu kopyala ile
     *                       alinan metin olacak
     */
    public static WebElement webelementJavaScript(String javascriptYolu) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement webElement = (WebElement) js.executeScript("return " + javascriptYolu + "");
        return webElement;
    }

    // JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    // JS Sayfa Basi Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    // JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    // JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    // JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String attribute_Value = (String) js
                .executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

    public static void clickWithJS(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    // locateyi bulana kadar bekle
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // elemente tiklamayi devre disi birakabilme
    public static void disableElementClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].addEventListener('click', function(e){ e.stopPropagation(); e.preventDefault(); }, true);",
                element);
    }









    public static void uploadFilePath(String filePath) {
        try {
            ReusableMethods.bekle(3);
//            Dosyayi bulmak icin kullandım
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//            ROBOT CLASS MASAUSTU UYGULAMARI ILE ILETISIME GECMEK ICIN KULLANDIM
            Robot robot = new Robot();
//          CONTROL TUSUNA BAS
            robot.keyPress(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
//            V TUSUNA BAS
            robot.keyPress(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            //releasing ctrl+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            System.out.println("YAPISTIRMA ISLEMI : PASSED");
            //pressing enter
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            //releasing enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            System.out.println("DOSYA YUKLENDI.");
        } catch (Exception e) {
        }
    }



}