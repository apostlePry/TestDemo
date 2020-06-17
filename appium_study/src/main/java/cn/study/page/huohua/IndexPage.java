package cn.study.page.huohua;

import cn.study.page.BasePage;
import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    public IndexPage(){
        super("cn.huohua.eduparent", ".activity.PaMainActivity");
    }

    public MinePage toMinePage(){
        this.switchToSpecificWebView(By.xpath("//*[@class='tab-bar-item']"));
        System.out.println(this.getContext());
        this.click(By.xpath("//*[@class='tab-bar-item'][5]"));
        return new MinePage();
    }
}
