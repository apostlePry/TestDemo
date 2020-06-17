package cn.study.page.huohua;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class MinePage extends BasePage {

    public UserSettingPage toUserSettingPage(){
        this.click(By.cssSelector(".titleBar-right"));
        return new UserSettingPage();
    }

}
