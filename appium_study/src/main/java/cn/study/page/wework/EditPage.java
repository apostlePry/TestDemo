package cn.study.page.wework;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class EditPage extends BasePage {

    public EditPage inputTheme(String themeName){
        this.input(By.id("b2k"), themeName);
        return this;
    }

    public EditPage selectTime(){
        this.click(By.id("aeg"));
        return this;
    }

    public void saveSchedule(){
        this.click(By.id("ag2"));
    }
}
