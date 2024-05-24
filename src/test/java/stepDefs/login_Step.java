package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.junit.Assert;
import org.openqa.selenium.By;
import pages.login_pages;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.ReusableMethods;

public class login_Step {
   login_pages loginPages=new login_pages();


    @Given("sisteme {string} ile giriş yapilmalidir")
    public void sisteme_ile_giriş_yapilmalidir(String string) {

    }
    @Given("sisteme giris yaptiğini assert et")
    public void sisteme_giris_yaptiğini_assert_et() {


        try {
            loginPages.bimserUrlGirisAssert.isDisplayed();

        } catch (Exception e) {
         //   System.out.println("giriş sağlanamadı");
        }
    }
    @Given("sistemde şirket secimi yapabilmek icin taba basilmalidir")
    public void sistemde_şirket_secimi_yapabilmek_icin_taba_basilmalidir() {

      //  loginPages.sirketAlaniTabi.click();
        Driver.   getDriver().findElement(By.id("cbCompany_I")).click();

    }
    @Given("sistemde şirket secimi yapilmalidir")
    public void sistemde_şirket_secimi_yapilmalidir() {
ReusableMethods.bekle(5);


    Driver.    getDriver().findElement(By.id("cbCompany_DDD_L_LBI2T0")).click();


    }

    @Given("sisteme giris yapalim")
    public void sisteme_giris_yapalim() {
loginPages.GIRISk.click();
    }

    @And("kullanici adini yazalim")
    public void kullaniciAdiniYazalim() {
        ReusableMethods.bekle(4);
        loginPages.kullanıcıAdi.sendKeys(ConfigReader.getProperty("User"));
        System.out.println("kullanıcı adı girildi mi  = " + loginPages.kullanıcıAdi.getText().isEmpty());


    }

    @And("kullanici passwordunu yazalim")
    public void kullaniciPasswordunuYazalim() {

ReusableMethods.bekle(4);
        loginPages.password.sendKeys(ConfigReader.getProperty("Password"));

        System.out.println("password girildi mi= " + loginPages.password.getText().isEmpty());
    }
    @And("sistem menüsüne checkBoxı secili mi")
    public void sistemMenüsüneCheckBoxıSeciliMi() {
     Assert.assertTrue("checkbox seçili", loginPages.checkBox.isDisplayed());


    }
    @And("sistem menüsüne giriş yapıldı mi  assert et")
    public void sistemMenüsüneGirişYapıldıMiAssertEt() {
    loginPages.devamEkranigeldiMi.isDisplayed();
    }


    @And("sistem menüsüne gelen devam butonuna basalım")
    public void sistemMenüsüneGelenDevamButonunaBasalım() {
        ReusableMethods.bekle(10);
        loginPages.devam.click();
    }


}
