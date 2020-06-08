package cn.study.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowTest {

    private static WebDriver driver;

    @BeforeAll
    public static void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSwitchWindow(){
        driver.get("https://www.baidu.com");

        WebElement loginButton = driver.findElement(By.cssSelector(".s-top-login-btn"));
        loginButton.click();

        String windowHandle = driver.getWindowHandle();

        WebElement registerButton = driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']"));
        registerButton.click();

        for (String handle : driver.getWindowHandles()) {
            if (!windowHandle.equalsIgnoreCase(handle)){
                driver.switchTo().window(handle);

                WebElement userName = driver.findElement(By.id("TANGRAM__PSP_4__userName"));
                userName.clear();
                userName.sendKeys("test");

                WebElement phone = driver.findElement(By.id("TANGRAM__PSP_4__phone"));
                phone.clear();
                phone.sendKeys("12500000065");
                driver.switchTo().window(windowHandle);
            }
        }

        WebElement userNameLoginButton = driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn"));
        userNameLoginButton.click();

        WebElement usernameInput = driver.findElement(By.id("TANGRAM__PSP_11__userName"));
        usernameInput.clear();
        usernameInput.sendKeys("12500000065");

        WebElement password = driver.findElement(By.id("TANGRAM__PSP_11__password"));
        password.clear();
        password.sendKeys("12500000065");

    }

    @AfterAll
    public static void after(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
