package cn.study.page.xueqiu;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage() {
        super("com.xueqiu.android", ".view.WelcomeActivityAlias");
    }

    public SearchPage toSearchPage() {
        this.click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage();
    }

    public MarketPage toMarketPage() {
        this.click(By.xpath("//*[@text='行情']"));
        return new MarketPage();
    }
}
