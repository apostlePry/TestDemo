package cn.study.page.huohua;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MinePageTest {
    private static IndexPage indexPage;
    private static MinePage minePage;

    @BeforeAll
    public static void before(){
        indexPage = new IndexPage();
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indexPage.quit();
    }

    @Test
    public void testStartHuoHua(){
        System.out.println(indexPage.getContext());
        System.out.println(indexPage.getContexts());
        System.out.println("火花思维家长端启动成功");
        minePage = indexPage.toMinePage();
        UserSettingPage userSettingPage = minePage.toUserSettingPage();
        String windowHandle = minePage.getWindowHandle();
        userSettingPage.switchToLastWindowHandle();
        userSettingPage.changeName("test");
    }
}
