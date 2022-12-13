package utillities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import static utillities.DriverMob.driverEmulateur;

public class ReusableMethods {

    public static void clickOnPage(String pageName)  {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<AndroidElement> pages = driverEmulateur().findElementsByClassName("android.widget.TextView");
        for (MobileElement page: pages) {
            if (page.getText().equals(pageName)){
                page.click();
                break;
            }else{
                scrollWithUiScrollable(pageName);
                break;
            }
        }
    }

    public static void scrollWithUiScrollable(String elementText){
        AndroidDriver driver = (AndroidDriver) driverEmulateur();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");
        driver.findElementByXPath("//*[@text='"+elementText+"']").click();
    }
}
