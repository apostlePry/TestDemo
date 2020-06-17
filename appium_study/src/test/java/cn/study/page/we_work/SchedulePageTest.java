package cn.study.page.we_work;

import cn.study.page.wework.EditPage;
import cn.study.page.wework.HomePage;
import cn.study.page.wework.SchedulePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SchedulePageTest {

    private static HomePage homePage;

    @BeforeAll
    public static void beforeAll(){
        homePage = new HomePage();
    }

    @AfterAll
    public static void afterAll(){
        homePage.quit();
    }

    @Test
    public void testAddSchedule(){
        SchedulePage schedulePage = homePage.toSchedulePage();
        EditPage editPage = schedulePage.addSchedule();
        editPage.inputTheme("demo1").selectTime().saveSchedule();
        Assertions.assertTrue(schedulePage.getScheduleName().contains("demo1"));
    }
}
