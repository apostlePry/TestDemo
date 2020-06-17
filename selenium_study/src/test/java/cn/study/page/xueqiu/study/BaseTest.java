package cn.study.page.xueqiu.study;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void initBrower(){
        String browerName = System.getenv("brower");
        if ("chrome".equalsIgnoreCase(browerName)){
            System.setProperty("webdriver.chrome.driver", "/Users/jiaqinwen/work/driver/chromedriver");
            driver = new ChromeDriver();
        }else if ("firefox".equalsIgnoreCase(browerName)){
            System.setProperty("webdriver.gecko.driver", "/Users/jiaqinwen/work/driver/geckodriver");
            driver = new FirefoxDriver();
        }else if ("safri".equalsIgnoreCase(browerName)){
            driver = new SafariDriver();
        }
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
