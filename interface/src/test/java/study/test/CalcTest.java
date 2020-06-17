package study.test;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalcTest {
    @Test
    @Tag("测试用例")
    @Link(name = "allure", type = "mylink", url = "https://home.testing-studio.com")
    public void divTest(){
        Allure.step("第一步");
        Calc calc = new Calc();
        Allure.step("第二步");
        Allure.addAttachment("test", "cccc");
        Allure.addAttachment("demo", "image/png",
                this.getClass().getResourceAsStream("/WechatIMG8.jpg"), ".jpg");
        Assertions.assertEquals(calc.div(2, 1), 2);
    }
}