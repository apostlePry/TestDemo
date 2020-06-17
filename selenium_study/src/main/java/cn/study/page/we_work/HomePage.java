package cn.study.page.we_work;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public ContactPage getContactPage(){
        // todo: 操作流程
        this.start();
        this.click(By.id("menu_contacts"));
        return new ContactPage();
    }
}
