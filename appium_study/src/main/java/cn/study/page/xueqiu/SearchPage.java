package cn.xueqiu.study.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage search(String keyWord){
        this.input(By.id("com.xueqiu.android:id/search_input_text"), keyWord);
        return this;
    }

    public SearchPage selectStock(Integer index){
        List<MobileElement> name = this.getElements(By.id("name"));
        if (name.size() > (index - 1)){
            MobileElement selectStock = name.get(index - 1);
            selectStock.click();
        }
        return this;
    }

    /**
     * @return 获取股票名称列表
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/8 4:21 下午
     */
    public List<String> getNameList(){
        List<String> nameList = new ArrayList<>();
        this.getElements(By.id("com.xueqiu.android:id/name"))
                .forEach(mobileElement -> nameList.add(mobileElement.getText()));
        return nameList;
    }

    /**
     * @return 选择加自选股票
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/8 4:20 下午
     */
    public SearchPage selectFollow(Integer index){
        List<MobileElement> followList = this.getElements(By.id("follow_btn"));
        if (followList.size() > (index - 1)){
            MobileElement followElement = followList.get(index - 1);
            followElement.click();
        }
        return this;
    }

    /**
     * @return 获取默认第一个价格
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/8 4:22 下午
     */
    public Double getPrice(){
        this.click(By.xpath("//*[@text = 'BABA']"));
        return Double.valueOf(this.getElement(By.id("current_price")).getText());
    }

    /**
     * 添加自选股票后，点击下次再说
     * @return
     */
    public SearchPage next(){
        try {
            this.click(By.id("tv_left"));
            return this;
        } catch (Exception e) {
            return this;
        }
    }

    /**
     * @return 点击取消按钮，退出当前页面
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/8 4:25 下午
     */
    public void close(){
        click(By.id("action_close"));
    }

}
