package cn.study.page.xueqiu.web.page;

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
