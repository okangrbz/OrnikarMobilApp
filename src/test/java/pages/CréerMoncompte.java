package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.DriverMob;

import java.time.Duration;

public class CréerMoncompte {




        public CréerMoncompte() {

            PageFactory.initElements(new AppiumFieldDecorator(DriverMob.driverEmulateur(), Duration.ofSeconds(30)), this);
        }


        @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
        public MobileElement boutoninscript;

        @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
        public MobileElement premierboutoninscr;


        @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
        public MobileElement prénom;

         @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
         public MobileElement nom;

         @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
         public AndroidElement codepostale;

         @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
         public MobileElement telNo;

         @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
         public MobileElement email;

         @AndroidFindBy(xpath = "(//android.widget.EditText)[6]")
         public MobileElement motdepass;

         @AndroidFindBy(xpath = "(//android.view.ViewGroup)[17]")
         public MobileElement datedenaissance;

         @AndroidFindBy(xpath = "//*[@text='JJ']")
         public MobileElement dtnDay;

         @AndroidFindBy(xpath = "//*[@text='MM']")
         public MobileElement dtnMont;

         @AndroidFindBy(id = "android:id/date_picker_header_year")
         public MobileElement dtnYear;

          @AndroidFindBy(xpath = "//*[@text='OK']")
          public MobileElement okbouton;

          @AndroidFindBy(xpath = "(//android.widget.CheckBox)[1]")
          public MobileElement case1;

         @AndroidFindBy(id = "sign-up-cgu-checkbox")
         public MobileElement case2;

        @AndroidFindBy(xpath = "(//android.view.ViewGroup)[30]")
        public MobileElement boutonvalide;







}