package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class homePages {
    public homePages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"init-app-menu\"]")
    public WebElement menü;
    @FindBy(xpath = "//span[normalize-space()='ANA MENÜ']")
    public WebElement anaMenüyeTikladiMi;
    @FindBy(xpath = "//h3[normalize-space()='Sistem']")
    public WebElement sistemTabinaTikla;


    @FindBy(xpath = "//h3[contains(text(),'Ortak Tanımlar')]")
    public WebElement ortakTanimlar;

    @FindBy(xpath = "//span[contains(text(),'Ortak Tanımlar')]")
    public WebElement ortakTanimlaraTikladiMi;
    @FindBy(xpath = "//h3[normalize-space()='Tatil Günleri']")
    public WebElement tatilGünleri;

    @FindBy(xpath = "//*[@id=\"TASPxRoundPanel1_xcbHolidayEntries_CapC\"]")
    public WebElement tatilGünlerineTikladiMi;


}
