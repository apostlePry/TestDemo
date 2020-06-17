package study.test;

import test.UserTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import test.GetYamlTest;
import test.Junit5DemoTest;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
        GetYamlTest.class,
        CalcTest.class,
        Junit5DemoTest.class,
        UserTest.class
})
public class SuiteTest {
}
