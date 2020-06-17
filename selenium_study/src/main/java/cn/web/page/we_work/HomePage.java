package cn.web.page.we_work;

import cn.web.page.BasePage;
import org.openqa.selenium.By;

public class HomePage {
    private static BasePage basePage = new BasePage();

    public ContactPage getContactPage(){
        // todo: 操作流程
        basePage.start();
        basePage.click(By.id("menu_contacts"));
        return new ContactPage();
    }
}
