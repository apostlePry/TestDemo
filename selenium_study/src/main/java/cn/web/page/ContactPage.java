package cn.web.page;

import org.openqa.selenium.By;

/**
 * 通讯录页面
 */
public class ContactPage extends BasePage {

    /**
     * 添加成员
     * @param username
     * @param accountId
     * @param phone
     * @return ContactPageAction
     * @author jiaqinwen
     * @creed: Talk is cheap,show me the code
     * @date 2020/6/3 5:21 下午
     */
    public ContactPage addMember(String username, String accountId, String phone) {
        click(By.linkText("添加成员"));
        inputByWait(By.name("username"), username);
        inputByWait(By.name("acctid"), accountId);
        inputByWait(By.name("mobile"), phone);
        clickByWait(By.cssSelector(".js_btn_save"));
        return this;
    }

    /**
     * 搜索成员
     * @param keyword
     * @return
     */
    public ContactPage searchMember(String keyword){
        input(By.cssSelector("#memberSearchInput"), keyword);
        return this;
    }

    /**
     * 删除
     * @return
     */
    public ContactPage delete(){
        clickByWait(By.cssSelector(".js_del_member"));
        click(By.linkText("确认"));
        return this;
    }

    public ContactPage add(){
        click(By.cssSelector(".member_colLeft_top_addBtn"));
        return this;
    }

    public ContactPage addParty(String partyName){
        click(By.cssSelector(".js_create_party"));
        input(By.name("name"), partyName);
        click(By.cssSelector(".js_toggle_party_list"));
        clickByWait(By.cssSelector(".jstree-2 #\\31 688852011662104_anchor"));
        click(By.linkText("确定"));
        return this;
    }

    public ContactPage deleteParty(){
        clickByWait(By.xpath("//a[contains(text(),'testParty')]"));
        clickByWait(By.xpath("/html/body/div[1]/div/div/main/div/div/div[1]/div/div[2]/div[2]/ul/li/ul/li[2]/a/span"));
        clickByWait(By.xpath("//a[contains(text(),'删除')]"));
        click(By.linkText("确定"));
        return this;
    }
}
