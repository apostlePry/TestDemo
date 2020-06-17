package cn.study.page.xueqiu.study.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InteractiveTest {

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
    public void clickTest(){
        driver.get("http://sahitest.com/demo/clicks.htm");
        WebElement element = driver.findElement(By.xpath("//input[@value = 'click me']"));
        WebElement dblElement = driver.findElement(By.xpath("//input[@value = 'dbl click me']"));
        WebElement rightElement = driver.findElement(By.xpath("//input[@value = 'right click me']"));
        // 单击
        actions.click(element);
        actions.perform();

        // 双击
        actions.doubleClick(dblElement).perform();

        // 右键点击
        actions.contextClick(rightElement).perform();
    }

    @Test
    public void moveTest(){
        // 移动
        driver.get("https://www.baidu.com");
        actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
        actions.perform();
    }

    @Test
    public void dragTest(){
        /*
            拖拽事件
        */
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        actions.dragAndDrop(driver.findElement(By.id("dragger")),
                driver.findElement(By.xpath("//div[@class = 'item'][3]"))).perform();

    }

    @Test
    public void keysTest(){
        driver.get("http://sahitest.com/demo/label.htm");
        List<WebElement> elements = driver.findElements(By.xpath("//input[@type = 'textbox']"));
        elements.get(0).sendKeys("test commad");
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        actions.keyDown(elements.get(1), Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
    }

    @Test
    public void scrollTest(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("霍格沃滋测试学院");
        driver.findElement(By.id("su")).click();

        TouchActions actions = new TouchActions(driver);
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
