package cn.study.page.xueqiu.study.demo;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartSeleniumTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void before(){
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void startSeleniumTest(){
        driver.get("https://home.testing-studio.com");
    }

    @Test
    public void loginTest(){
        driver.get("https://home.testing-studio.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement loginElement = driver.findElement(By.xpath("//span[contains(text(), '登录')]"));
        loginElement.click();

        WebElement userNameElement = driver.findElement(By.id("login-account-name"));
        userNameElement.clear();
        userNameElement.sendKeys("731971603@qq.com");

        WebElement passWordElement = driver.findElement(By.id("login-account-password"));
        passWordElement.clear();
        passWordElement.sendKeys("Xixi.52099");

        WebElement loginButtonElement = driver.findElement(By.cssSelector("#login-button > .d-button-label"));
        loginButtonElement.click();
    }

    @Test
    public void waitTest(){
        driver.get("https://home.testing-studio.com");

       /* WebElement loginElement = wait.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver input) {
                return driver.findElement(By.xpath("//span[contains(text(), '登录')]"));
            }
        });

        loginElement.click();*/

        WebElement loginElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '登录')]")));
        loginElement.click();
    }

    @AfterAll
    public static void after(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
