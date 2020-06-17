package test;

import test.api.UserApi;
import test.request.RequestHeader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Epic("Allure Epic Test")
@Feature("User Model Test")
public class UserTest {

    private RequestHeader requestHeader = RequestHeader.newInstance();
    private UserApi userApi = new UserApi();

    @Test
    @Story("Login Test")
    @Description("登录测试")
    public void loginTest(){
        Response response = userApi.login("18610056005", "8888");
        String token = response.then().body("data.userId", Matchers.equalTo(19))
                .extract().response().path("data.token");
        requestHeader.setUserToken(token);
        Integer userId = response.then().body("success", Matchers.equalTo(true))
                .extract().response().path("data.userId");
        requestHeader.put("userId", userId);
        Assertions.assertNotEquals(token, null);
    }

    @Test
    public void getUserInfoTest(){
        Integer userId = Integer.parseInt(String.valueOf(requestHeader.get("userId")));
        Response userInfo = userApi.first(userId);
        Integer user = userInfo.then().extract().path("data.userId");
        String userName = userInfo.then().extract().path("data.nickname");
        Assertions.assertAll("demo",
                () -> Assertions.assertEquals(userId, user),
                () -> Assertions.assertEquals(userName, "Rex")
        );
    }

    @Test
    @Disabled
    public void logoutTest(){
        System.out.println(requestHeader.getUserToken());
        userApi.logout();
    }
}
