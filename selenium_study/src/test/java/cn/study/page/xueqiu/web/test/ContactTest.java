package cn.study.page.xueqiu.web.test;

import cn.study.page.xueqiu.web.page.ContactPage;
import cn.study.page.xueqiu.web.page.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private static HomePage homePage = new HomePage();
    private static ContactPage contactPage = homePage.getContactPage();;

    @Test
    @Order(1)
    public void testAddMember(){
        contactPage.addMember("12", "12", "12500000000");
    }

    @Test
    @Order(2)
    public void testSearchMember(){
        contactPage.searchMember("12");
    }

    @Test
    @Order(3)
    public void testDelete(){
        contactPage.delete();
    }

    @Test
    @Order(4)
    public void testXAddParty(){
        contactPage.add().addParty("testParty");
        contactPage.deleteParty();
    }

    @AfterAll
    public static void after(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contactPage.quit();
    }
}
