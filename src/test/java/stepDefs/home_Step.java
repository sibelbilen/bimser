package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.homePages;
import utilities.ReusableMethods;

public class home_Step {

    homePages home=new homePages();

    @Given("menüye tıklayalım")
    public void menüyeTıklayalım() {
        ReusableMethods.bekle(8);
        home.menü.click();
    }
    @And("menüye tikladi mi")
    public void menüyeTikladiMi() {
        ReusableMethods.bekle(8);
        home.anaMenüyeTikladiMi.isDisplayed();
    }


    @Given("menü icerisinde bulunan sistem tabina tikla")
    public void menüIcerisindeBulunanSistemTabinaTikla() {
        home.sistemTabinaTikla.click();
    }



    @Given("menü icerisinde bulunan sistem tabina tikla ve çıkan menüden ortak tanımlara tikla")
    public void menüIcerisindeBulunanSistemTabinaTiklaVeÇıkanMenüdenOrtakTanımlaraTikla() {
        ReusableMethods.bekle(10);
        home.ortakTanimlar.click();
        ReusableMethods.bekle(10);
    }

    @Given("menü icerisinde bulunan sistem tabina tikla ve çıkan menüden ortak tanımlara tikla bu menüden çikan tail günlerine tikla")
    public void menüIcerisindeBulunanSistemTabinaTiklaVeÇıkanMenüdenOrtakTanımlaraTiklaBuMenüdenÇikanTailGünlerineTikla() {
        home.tatilGünleri.click();
    }


    @Given("tatil günlerine tikladi mi")
    public void tatilGünlerineTikladiMi() {
        ReusableMethods.bekle(5);
        home.tatilGünlerineTikladiMi.isDisplayed();
    }
}


