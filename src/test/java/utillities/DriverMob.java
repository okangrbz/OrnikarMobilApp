package utillities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverMob {

    public static AndroidDriver<AndroidElement> driver(){

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "okangurbuz_S5Vr4X");
        caps.setCapability("browserstack.key", "7k4wfYxydvec1HDzXcdD");

        // Set URL of the application under test
        caps.setCapability("app", "bs://b21d7efe33406c63cbd9cd156376cfdeb7a25249");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S22");
        caps.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return driver;
    }





}
