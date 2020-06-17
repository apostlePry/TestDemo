package cn.study.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BasePage {
    protected static AppiumDriver<MobileElement> driver;
    protected static TouchAction touchAction;
    protected static WebDriverWait wait;

    public BasePage() {
    }

    public BasePage(String appPackage, String appActivity) {
        this.startApp(appPackage, appActivity);
    }

    public void startApp(String appPackage, String appActivity) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("appPackage", appPackage);
            desiredCapabilities.setCapability("appActivity", appActivity);
            desiredCapabilities.setCapability("chromedriverExecutable", "/Users/jiaqinwen/work/utils/appium/driver/chromedriver");
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

    protected MobileElement getElement(By by) {
        return driver.findElement(by);
    }

    protected List<MobileElement> getElements(By by) {
        return driver.findElements(by);
    }

    public void click(By locator) {
        try {
            MobileElement element = this.getElement(locator);
            element.click();
        } catch (Exception e) {
            System.out.println("点击失败原因 ---> " + e.getMessage());
            System.out.println("--------使用等待点击--------");
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void waitClick(By locator, By by) {
        do {
            MobileElement element = this.getElement(locator);
            element.click();
        } while (this.getElements(by).size() > 0);
    }

    public void input(By locator, String value) {
        MobileElement element = this.getElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public Set<String> getContexts(){
        return driver.getContextHandles();
    }

    public String getContext(){
        return driver.getContext();
    }

    public void switchToWebView(){
        List<String> webViewContextNames =  this.getContexts().stream().filter(
                contextName -> contextName.contains("WEBVIEW_")).collect(Collectors.toList());
        String currentContextView = "";

        if (webViewContextNames.size() > 0){
            currentContextView = (String) webViewContextNames
                    .toArray()[webViewContextNames.size()-1];
            driver.context(currentContextView);
        }
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public void switchToWindowHandle(String windowHandle){
        driver.switchTo().window(windowHandle);
    }

    public void switchToLastWindowHandle(){
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindowHand = "";
        if (windowHandles.size() > 0){
            currentWindowHand = (String) windowHandles.toArray()[windowHandles.size() - 1];
            driver.switchTo().window(currentWindowHand);
        }
    }

    public void switchToSpecificWebView(By locator){
        Long beginTime = System.currentTimeMillis();
        do{
            try{
                List<MobileElement> elements = this.getElements(locator);
                if (elements.size() > 0){
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            this.switchToWebView();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while ((System.currentTimeMillis() - beginTime) > (30 * 1000));
    }

    public void quit() {
        driver.quit();
    }
}
