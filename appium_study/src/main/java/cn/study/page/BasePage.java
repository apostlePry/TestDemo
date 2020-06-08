package cn.study.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static AppiumDriver<MobileElement> driver;
    protected static TouchAction touchAction;
    protected static WebDriverWait wait;

    static {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            touchAction = new TouchAction(driver);
            wait = new WebDriverWait(driver, 50, 500);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected MobileElement getElement(By by){
        return driver.findElement(by);
    }

    protected List<MobileElement> getElements(By by){
        return driver.findElements(by);
    }

    public void quit(){
        driver.quit();
    }
}
