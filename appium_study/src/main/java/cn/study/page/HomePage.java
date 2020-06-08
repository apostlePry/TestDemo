package cn.study.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public SearchPage toSearchPage(){
        MobileElement searchInputButton = this.getElement(By.id("com.xueqiu.android:id/home_search"));
        searchInputButton.click();
        return new SearchPage();
    }

    public MarketPage toMarketPage(){
        MobileElement marketPageButton = this.getElement(By.xpath("//*[@text='行情']"));
        marketPageButton.click();
        return new MarketPage();
    }
}
