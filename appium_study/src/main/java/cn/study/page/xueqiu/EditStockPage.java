package cn.xueqiu.study.page;

import org.openqa.selenium.By;

public class EditStockPage extends BasePage {

    public EditStockPage selectCheck(){
        this.getElements(By.id("check")).forEach(mobileElement ->
            mobileElement.click()
        );
        return this;
    }

    public EditStockPage cancelFollow(){
        this.click(By.id("cancel_follow"));
        return this;
    }

    public EditStockPage confirm(){
        this.click(By.id("tv_right"));
        return this;
    }

    public void close(){
        this.click(By.id("action_close"));
    }
}
