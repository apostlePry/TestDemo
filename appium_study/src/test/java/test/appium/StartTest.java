package cn.study.page.xueqiu.test.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class StartTest extends BaseTest {


    @Test
    public void sampleTest() {
        MobileElement homeSearch = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        String enabled = homeSearch.getAttribute("enabled");
        System.out.println(homeSearch.getLocation());
        if ("true".equals(enabled)) {
            homeSearch.click();
            MobileElement searchInput = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            String displayed = searchInput.getAttribute("displayed");
            if ("true".equals(displayed)) {
                System.out.println("search success!");
                searchInput.clear();
                searchInput.sendKeys("alibaba");
            } else {
                System.out.println("search failed");
            }
        }
        MobileElement el3 = driver.findElement(By.xpath("//*[@text = 'BABA']"));
        el3.click();
    }

    @Test
    public void testSwipe() {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        MobileElement homeSearch = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        String enabled = homeSearch.getAttribute("enabled");
        if ("true".equals(enabled)) {
            touchAction.press(PointOption.point((width / 2), (height / 10 * 8)));
            touchAction.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)));
            touchAction.moveTo(PointOption.point((width / 2), (height / 10 * 2)));
            touchAction.release().perform();
        }
    }

    @Test
    public void testGetPrice() {
        MobileElement homeSearch = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        String enabled = homeSearch.getAttribute("enabled");
        System.out.println(homeSearch.getLocation());
        if ("true".equals(enabled)) {
            homeSearch.click();
            MobileElement searchInput = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            String displayed = searchInput.getAttribute("displayed");
            if ("true".equals(displayed)) {
                System.out.println("search success!");
                searchInput.clear();
                searchInput.sendKeys("alibaba");
            } else {
                System.out.println("search failed");
            }
        }
        MobileElement el3 = driver.findElement(By.xpath("//*[@text = 'BABA']"));
        el3.click();
        MobileElement price = driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']"));
        System.out.println(price.getText());
    }

    @Test
    public void testUiSelectorElement() {
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        MobileElement elementByHangQing = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"行情\")");
        elementByHangQing.click();

        MobileElement elementByJiaoYi = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")");
        elementByJiaoYi.click();
    }

    @Test
    public void testScrollable(){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        MobileElement scrollable = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"5G滚雪球\").instance(0))");
        scrollable.click();
    }
}
