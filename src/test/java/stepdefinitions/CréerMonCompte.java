package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.aspectj.weaver.bcel.FakeAnnotation;
import org.junit.Test;
import pages.CréerMoncompte;
import utillities.DriverOrn;

public class CréerMonCompte {
    CréerMoncompte element=new CréerMoncompte();
    Faker fek=new Faker();

    @Given("L'utilisateur se rend à l'app Ornikar")
    public void l_utilisateur_se_rend_à_l_app_ornikar() {
       DriverOrn.driver();

    }




    @When("L'utilisateur clique sur le bouton Je m'inscris gratuitment.")
    public void l_utilisateur_clique_sur_le_bouton_je_m_inscris_gratuitment() {
        element.cookieOk.click();
        element.boutoninscript.click();
    }
    @When("L'utilisateur accepte les cookies.")
    public void l_utilisateur_accepte_les_cookies() {
        if (element.cookieOk.isEnabled()){
            element.cookieOk.click();
        }


    }
    @When("L'utilisateur renseigne ses informations")
    public void l_utilisateur_renseigne_ses_informations() {
       element.prénom.sendKeys(fek.name().firstName());
       element.nom.sendKeys(fek.name().lastName());
       element.datedenaissance.sendKeys(fek.date().birthday().toString());
        element.nom.sendKeys("67000");
        element.telNo.sendKeys(fek.phoneNumber().phoneNumber());
        element.email.sendKeys(fek.internet().emailAddress());
        element.motdepass.sendKeys(fek.internet().password(12,15));




    }
    @When("L'utilisateur coche deux cases d'acceptations")
    public void l_utilisateur_coche_deux_cases_d_acceptations() {


    }
    @When("L'utilisateur tape sur le bouton Valide")
    public void l_utilisateur_tape_sur_le_bouton_valide() {

    }
    @Then("L'utilisateur confirme qu il est bien connecté au site en vérifiant son nom qui s'affiche sur la page confirmation.")
    public void l_utilisateur_confirme_qu_il_est_bien_connecté_au_site_en_vérifiant_son_nom_qui_s_affiche_sur_la_page_confirmation() {

    }

    @When("L{string}inscris gratuitment.")
    public void lUtilisateurCliqueSurLePremierBoutonJeMInscrisGratuitment() {

        if ((element.boutoninscript.isEnabled())){
            element.boutoninscript.click();
        }
        element.premierboutoninscr.click();
    }
}
