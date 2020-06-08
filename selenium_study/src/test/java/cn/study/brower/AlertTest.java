package cn.study.brower;

import cn.study.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AlertTest extends BaseTest {

    @Test
    public void testAlert(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            driver.switchTo().frame("iframeResult");
            Actions action = new Actions(driver);

            WebElement childFrame = driver.findElement(By.id("draggable"));
            WebElement droppable = driver.findElement(By.id("droppable"));

            action.dragAndDrop(childFrame, droppable).perform();

            Thread.sleep(3000);

            driver.switchTo().alert().accept();
            Thread.sleep(3000);
            driver.switchTo().parentFrame();

            WebElement submitBTN = driver.findElement(By.id("submitBTN"));
            System.out.println(submitBTN.getText());
            submitBTN.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
