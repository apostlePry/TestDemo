package cn.study.page.xueqiu.web.page;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    public Boolean elementIsExits(By locator){
        try {
            this.getElementByWait(locator);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public WebElement getElementByWait(By by) {
        return wait.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver input) {
                return driver.findElement(by);
            }
        });
    }

    public void input(By by, String content){
        WebElement element = this.getElement(by);
        element.clear();
        element.sendKeys(content);
    }

    public void inputByWait(By by, String keyword){
        WebElement element = this.getElementByWait(by);
        element.clear();
        element.sendKeys(keyword);
    }

    /**
     * @param by
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/4 11:50 上午
     */
    public void click(By by){
        WebElement element = this.getElement(by);
        element.click();
    }

    public void clickByWait(By by){
        WebElement elementByWait = this.getElementByWait(by);
        elementByWait.click();
    }

    public void quit(){
        driver.quit();
    }

    public void start() {
        driver.get("https://work.weixin.qq.com/");
        WebElement loginButton = driver.findElement(By.cssSelector(".index_top_operation_loginBtn"));
        loginButton.click();
        try {
            FileReader fileReader = new FileReader("cookies.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                Date expiry = null;
                String date = tokenizer.nextToken();
                if (!date.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    expiry = sdf.parse(date);
                }
                Boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
    }
}
