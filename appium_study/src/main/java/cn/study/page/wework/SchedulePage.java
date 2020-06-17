package cn.study.page.wework;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SchedulePage extends BasePage {

    public EditPage addSchedule(){
        this.click(By.id("gym"));
        return new EditPage();
    }

    public List<String> getScheduleName(){
        List<String> scheduleNames = new ArrayList<>();
        this.getElements(By.id("gg_")).forEach(element -> scheduleNames.add(element.getText()));
        return scheduleNames;
    }
}
