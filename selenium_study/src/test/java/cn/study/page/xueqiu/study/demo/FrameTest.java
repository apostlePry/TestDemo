package cn.study.page.xueqiu.study.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    @BeforeAll
    public static void before(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void testSwitchFrame(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.switchTo().frame("iframeResult");

        WebElement childFrame = driver.findElement(By.id("draggable"));
        System.out.println(childFrame.getText());

        driver.switchTo().parentFrame();
        WebElement parentFrame = driver.findElement(By.id("submitBTN"));
        System.out.println(parentFrame.getText());
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
