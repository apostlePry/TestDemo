package cn.study.page.xueqiu.test.appium;

import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitTest extends BaseTest {

    @Test
    public void testWait(){
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
        WebElement codeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text = 'BABA']")));
        codeElement.click();
    }
}
