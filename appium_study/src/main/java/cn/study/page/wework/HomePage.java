package cn.study.page.wework;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage(){
        super("com.tencent.wework", ".launch.WwMainActivity");
    }


    public SchedulePage toSchedulePage(){
        this.click(By.id("adv"));
        return new SchedulePage();
    }

}
