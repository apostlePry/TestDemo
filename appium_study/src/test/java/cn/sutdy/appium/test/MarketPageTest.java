package cn.sutdy.appium.test;

import cn.study.page.EditStockPage;
import cn.study.page.HomePage;
import cn.study.page.MarketPage;
import cn.study.page.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarketPageTest {
    private static HomePage homePage;
    private static MarketPage marketPage;

    @BeforeAll
    public static void before(){
        homePage = new HomePage();
        marketPage = homePage.toMarketPage();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba",
            "jd"
    })
    public void addStockTest(String kewWord){
        SearchPage search = marketPage.search();
        search.search(kewWord).selectStock(1);
        search.selectFollow(1).next().close();
    }

    @Test
    public void deleteStockTest(){
        EditStockPage editPage = marketPage.edit();
        editPage.selectCheck().cancelFollow();
        editPage.confirm().close();
    }

    @AfterAll
    public static void after(){
        homePage.quit();
    }
}
