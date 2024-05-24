package stepDefs;

import io.cucumber.java.en.And;
import pages.loginNegatif_pages;
import pages.login_pages;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;

public class loginNeagtif_Step {

    loginNegatif_pages negatif= new  loginNegatif_pages();
    login_pages login=new login_pages();


    @And("kullanici adini yanlış giriş yapalim")
    public void kullaniciAdiniYanlışGirişYapalim() {
        login.kullanıcıAdi.sendKeys(ConfigReader.getProperty("userNegatif"));

    }

    @And("kullanici passwordunu negatif yazalim")
    public void kullaniciPasswordunuNegatifYazalim() {
        login.password.sendKeys(ConfigReader.getProperty("NegatifPassword"));
    }

    @And("kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi")
    public void kullaniciYanlışKullaniciVePasswordGirişiYaptığındaHataMesajıGeldiMi() {

        ReusableMethods.bekle(4);
assertEquals("Kullanıcı Adı veya Şifre Hatalı! Lütfen Kontrol Ediniz.",negatif.message.getText());


    }

    @And("kullanıcı adı alanı boş bırakılır")
    public void kullanıcıAdıAlanıBoşBırakılır() {


    }

    @And("kullanıcı şifre alanı boş bırakılır")
    public void kullanıcıŞifreAlanıBoşBırakılır() {

    }




    @And("kullanıcı adını üç karakterden daha kısa girelim")
    public void kullanıcıAdınıÜçKarakterdenDahaKısaGirelim() {
        login.kullanıcıAdi.sendKeys("ddd");

    }

    @And("kullanıcı şifresini beş karakterden daha kısa girelim")
    public void kullanıcıŞifresiniBeşKarakterdenDahaKısaGirelim() {
        login.password.sendKeys("123456");

    }

    @And("kullanıcı adını yanlış giriş yapalım")
    public void kullanıcıAdınıYanlışGirişYapalım() {
        login.kullanıcıAdi.sendKeys("ddd");

    }

    @And("kullanıcı şifresini doğru girelim")
    public void kullanıcıŞifresiniDoğruGirelim() {
        login.password.sendKeys(ConfigReader.getProperty("Password"));
    }

    @And("doğru kullanıcı adını girelim")
    public void doğruKullanıcıAdınıGirelim() {
        login.kullanıcıAdi.sendKeys("BEAM");
    }

    @And("kullanıcı şifresini yanlış girelim")
    public void kullanıcıŞifresiniYanlışGirelim() {
        login.password.sendKeys("123456");
    }

    @And("tamam'a bas")
    public void tamamABas() {
        negatif.tamam.click();
    }
}
