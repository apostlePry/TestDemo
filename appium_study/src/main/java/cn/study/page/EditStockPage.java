package cn.study.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class EditStockPage extends BasePage {

    public EditStockPage selectCheck(){
        this.getElements(By.id("check")).forEach(mobileElement -> {
            mobileElement.click();
        });
        return this;
    }

    public EditStockPage cancelFollow(){
        MobileElement cancelFollow = this.getElement(By.id("cancel_follow"));
        cancelFollow.click();
        return this;
    }

    public EditStockPage confirm(){
        MobileElement tvRight = this.getElement(By.id("tv_right"));
        tvRight.click();
        return this;
    }

    public void close(){
        MobileElement close = this.getElement(By.id("action_close"));
        close.click();
    }
}
