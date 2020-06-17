package cn.xueqiu.study.page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class MarketPage extends BasePage {

    public SearchPage search(){
        this.click(By.id("action_search"));
        return new SearchPage();
    }

    public EditStockPage edit(){
        this.click(By.id("edit_group"));
        return new EditStockPage();
    }

    public List<String> getStockName(){
        List<String> stockNames = new ArrayList<>();
        this.getElements(By.id("portfolio_stockName"))
                .forEach(x -> stockNames.add(x.getText())
        );
        return stockNames;
    }
}
