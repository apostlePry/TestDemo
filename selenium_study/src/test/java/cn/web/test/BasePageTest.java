package cn.web.test;

import cn.study.page.we_work.HomePage;
import cn.study.pojo.TestCase;
import org.junit.jupiter.api.Test;

public class BasePageTest {
    @Test
    public void testLoad(){
        HomePage homePage = new HomePage();
        TestCase testCase = homePage.load();
        System.out.println(testCase.getName());
        System.out.println(testCase.getDescription());
        testCase.getSteps().forEach(
                map -> {
                    System.out.println(map);
                }
        );
    }
}
