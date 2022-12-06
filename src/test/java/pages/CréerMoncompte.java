package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utillities.DriverMob;

import java.time.Duration;

public class CréerMoncompte {




        public CréerMoncompte() {

            PageFactory.initElements(new AppiumFieldDecorator(DriverMob.driver(), Duration.ofSeconds(30)), this);
        }


        @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
        public WebElement boutoninscript;

        @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
        public WebElement premierboutoninscr;


        @AndroidFindBy(xpath = "//*[@text='OK pour moi']")
        public WebElement cookieOk;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
        public WebElement prénom;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
        public WebElement nom;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
        public WebElement codepostale;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
        public WebElement telNo;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
        public WebElement email;

        @AndroidFindBy(xpath = "(//android.widget.EditText)[6]")
        public WebElement motdepass;

        @AndroidFindBy(xpath = "(//android.view.ViewGroup)[17]")
        public WebElement datedenaissance;



}