package utillities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class DriverMob {



    public  AppiumDriver<MobileElement> driverBrowserStack(){

        AppiumDriver<MobileElement> driverBrowserSteck;
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
         driverBrowserSteck = null;
        try {
            driverBrowserSteck = new AndroidDriver<MobileElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return driverBrowserSteck;
    }

    private static AppiumDriver<AndroidElement> appiumDriver;
    public static AppiumDriver<AndroidElement> driverEmulateur(){
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability("autoAcceptAlert",true);

            if (ConfigReader.getProperty("platformName").equals("Android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"
                desiredCapabilities.setCapability("appPackage","");
                desiredCapabilities.setCapability("appActivity","");
                appiumDriver = new AndroidDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (ConfigReader.getProperty("platformName").equals("ios")) {
                //if you do not provide app path so you should use "bundleId"
                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
                appiumDriver = new IOSDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
        }
        return appiumDriver;

    }
}
