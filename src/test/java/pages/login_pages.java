package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class login_pages {

    public login_pages() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"xppcProcurationList_xbtnContinue\"]")
    public WebElement devam;

    @FindBy(xpath = "//span[@id='xppcProcurationList_xlbProcurationHeader']")
    public WebElement devamEkranigeldiMi;
    @FindBy(xpath = "//span[@id='xppcProcurationList_xrblProcurationList_RB0_I_D']")
    public WebElement checkBox;

    @FindBy(xpath = "//input[@id='teUser_I']")
    public WebElement kullanıcıAdi;

    @FindBy(xpath = "//input[@id='PV_I']")
    public WebElement password;



    @FindBy(xpath= "//span[contains(text(),'GİRİŞ')]")
    public WebElement GIRISk;

    @FindBy(xpath = "//img[@id='login-logo']")
    public WebElement bimserUrlGirisAssert;
    @FindBy(xpath = "//div[@class='dashboardHeader']")
    public WebElement beamAnaEkrandaMi;
}
