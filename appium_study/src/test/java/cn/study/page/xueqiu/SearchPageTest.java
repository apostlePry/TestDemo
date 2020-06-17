package cn.study.page.xueqiu.sutdy.appium.test;

import cn.study.page.xueqiu.HomePage;
import cn.study.page.xueqiu.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchPageTest {
    private static HomePage homePage;
    private static SearchPage searchPage;
    @BeforeAll
    public static void before(){
        homePage = new HomePage();
        searchPage = homePage.toSearchPage();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,   阿里巴巴",
            "jd,    京东"
    })
    public void searchTest(String keyWord, String name){
        Assertions.assertEquals(searchPage.search(keyWord).getNameList().get(0), name);
    }

    @Test
    public void priceTest(){
        Assertions.assertTrue(searchPage.search("alibaba").getPrice() > 200);
    }

    @AfterAll
    public static void after(){
        searchPage.quit();
    }
}
