package cn.study.page.huohua;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class UserSettingPage extends BasePage {

    public UserSettingPage replaceHeadImg(){
//        this.click(By.xpath("//input[@type='file']"));
        this.input(By.xpath("//input[@type='file']"), "/data/media/0/DCIM/Camera/IMG_20200612_154038.jpg");
        return this;
    }

    public UserSettingPage changeName(String name){
        this.click(By.cssSelector("a.flex.middle.setting-list-item"));
        new EditName().editName(name);
        System.out.println(driver.getWindowHandles().size());
        return this;
    }

    class EditName extends BasePage{
        public void editName(String nickName){
            System.out.println(driver.getWindowHandles().size());
            this.switchToLastWindowHandle();
            this.input(By.cssSelector(".field-input"), nickName);
            this.click(By.cssSelector(".submit-btn"));
        }
    }
}
