package cn.xueqiu.study.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public SearchPage toSearchPage() {
        this.click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage();
    }

    public MarketPage toMarketPage() {
        this.click(By.xpath("//*[@text='行情']"));
        return new MarketPage();
    }
}
