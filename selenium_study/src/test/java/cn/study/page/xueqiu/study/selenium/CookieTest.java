package cn.study.page.xueqiu.study.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class CookieTest {
    private WebDriver driver;

    @BeforeEach
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testAddCookie() {
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

    @Test
    public void testGetCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
    }

    @Test
    public void testSaveCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        try {
            FileWriter writer = new FileWriter("cookies.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Cookie cookie : cookies) {
                bufferedWriter.write(cookie.getName()
                        + ";" + cookie.getValue()
                        + ";" + cookie.getPath()
                        + ";" + cookie.getDomain()
                        + ";" + cookie.getExpiry()
                        + ";" + cookie.isSecure()
                );
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void after() {
        try {
            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
