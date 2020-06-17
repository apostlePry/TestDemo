package cn.study.page.xueqiu;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


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
        Assertions.assertTrue(searchPage.search("alibaba").getPrice("BABA") > 200);
    }

    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    public void priceDataTest(String name, String code, Double price){
        Double realPrice = searchPage.search(name).getPrice(code);
        MatcherAssert.assertThat("实际价格大于期望价格：", realPrice, Matchers.greaterThan(price));
    }

    private static Stream<Arguments> byNameGetPrice(){
        return Stream.of(
                Arguments.of("阿里巴巴", "BABA", 200d),
                Arguments.of("网易", "NTES", 120d),
                Arguments.of("百度", "BIDU", 108d),
                Arguments.of("谷歌", "GOOG", 400d)
        );
    }

    @AfterAll
    public static void after(){
        searchPage.quit();
    }
}
