package stepdefinitions;

import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import pages.CréerMoncompte;
import utillities.ConfigReader;

import static utillities.DriverMob.driverEmulateur;
import static utillities.ReusableMethods.clickOnPage;

public class CréerMonCompte {
    CréerMoncompte element=new CréerMoncompte();
    Faker fek=new Faker();
    TouchAction actions=new TouchAction<>(driverEmulateur());


    @Given("L'utilisateur se rend à l'app Ornikar")
    public void l_utilisateur_se_rend_à_l_app_ornikar()  {

        driverEmulateur();


    }




    @When("L'utilisateur clique sur le bouton Je m'inscris gratuitment.")
    public void l_utilisateur_clique_sur_le_bouton_je_m_inscris_gratuitment() {

        element.boutoninscript.click();
    }

    @When("L'utilisateur renseigne ses informations")
    public void l_utilisateur_renseigne_ses_informations() {
        String fekname=fek.name().firstName();
        element.prénom.sendKeys(fekname);
        element.nom.sendKeys(fek.name().lastName());
        element.dtnDay.click();
        element.dtnYear.click();


        Dimension dimension=driverEmulateur().manage().window().getSize();

        int stratX= (int) (dimension.width*0.5);
        int startY= (int) (dimension.height*0.5);
        int finiX= (int) (dimension.width*0.5);
        int finiY= (int) (dimension.height*0.9);

        int count=0;
        while (count<=6) {
          actions.press(PointOption.point(stratX, startY))
          .moveTo(PointOption.point(finiX, finiY)).perform();
          count++;
      }
        driverEmulateur().findElementByXPath("//*[@text='1984']").click();
        element.okbouton.click();

        element.codepostale.sendKeys(ConfigReader.getProperty("codePostale"));
        element.telNo.sendKeys(ConfigReader.getProperty("phone"));
        element.email.sendKeys(fek.internet().emailAddress());
        element.motdepass.sendKeys(ConfigReader.getProperty("pass"));







    }
    @When("L'utilisateur coche deux cases d'acceptations")
    public void l_utilisateur_coche_deux_cases_d_acceptations() throws InterruptedException {

        AndroidDriver driver= (AndroidDriver) driverEmulateur();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"J’accepte et je comprends les conditions générales d’utilisation et la politique de confidentialité d’Ornikar\"))");
        ((AndroidDriver<AndroidElement>) driverEmulateur()).findElementByAndroidUIAutomator("UiSelector().resourceId(\"sign-up-cgu-checkbox\").index(0).checked(false)").click();
        clickOnPage("J’accepte de recevoir des offres commerciales de la part d’Ornikar");




    }
    @When("L'utilisateur tape sur le bouton Valide")
    public void l_utilisateur_tape_sur_le_bouton_valide() throws InterruptedException {
        clickOnPage("Valider");

    }
    @Then("L'utilisateur confirme qu il est bien connecté au site en vérifiant son nom qui s'affiche sur la page confirmation.")
    public void l_utilisateur_confirme_qu_il_est_bien_connecté_au_site_en_vérifiant_son_nom_qui_s_affiche_sur_la_page_confirmation() throws InterruptedException {



    }

}
