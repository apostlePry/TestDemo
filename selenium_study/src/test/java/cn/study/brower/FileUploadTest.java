package cn.study.brower;

import cn.study.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadTest extends BaseTest {

    @Test
    public void testUploadImage(){
        try {
            driver.get("https://www.baidu.com");
            WebElement imgButton = driver.findElement(By.cssSelector("span .soutu-btn"));
            imgButton.click();
            Thread.sleep(3000);
            WebElement uploadFileButton = driver.findElement(By.cssSelector("input.upload-pic"));
            uploadFileButton.sendKeys("/Users/jiaqinwen/Pictures/zhuanpan.png");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
