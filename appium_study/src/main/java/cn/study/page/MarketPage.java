package cn.study.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class MarketPage extends BasePage {

    public SearchPage search(){
        MobileElement searchActionButton = this.getElement(By.id("action_search"));
        searchActionButton.click();
        return new SearchPage();
    }

    public EditStockPage edit(){
        MobileElement editGroup = this.getElement(By.id("edit_group"));
        editGroup.click();
        return new EditStockPage();
    }
}
