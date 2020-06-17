package cn.study.page.xueqiu.study.brower;

import cn.study.page.xueqiu.study.BaseTest;
import org.junit.jupiter.api.Test;

public class BrowerTest extends BaseTest {

    @Test
    public void testStartBrower(){
        driver.get("https://home.testing-studio.com");
    }
}
