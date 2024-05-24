package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class loginNegatif_pages {

    public loginNegatif_pages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


@FindBy(xpath = "//span[@id='xmmMessage']")
public WebElement message;

    @FindBy(xpath = "//*[@id=\"MessageBox1_xpcMsgBox_xbtnOK_CD\"]")
public WebElement tamam;

}
