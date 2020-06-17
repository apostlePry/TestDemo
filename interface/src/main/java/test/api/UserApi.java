package test.api;

import test.request.RequestHeader;
import test.util.ParamUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserApi extends BaseApi {
    private static RequestHeader requestHeader = RequestHeader.newInstance();
    public Response login(String phone, String authCode){
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("authCode", authCode);
        ParamUtils.setParams(map);
        Response response = this.parseSteps();
        ParamUtils.clear();
        return response;
    }

    public Response logout(){
        String userToken = requestHeader.getUserToken();
        Map<String, Object> map = new HashMap<>();
        map.put("user-token", userToken);
        ParamUtils.setParams(map);
        Response response = this.parseSteps();
        ParamUtils.clear();
        return response;
    }

    public Response first(Integer userId){
        requestHeader.put("userId", userId);
        Map<String, Object> map = requestHeader.getMap();

        ParamUtils.setParams(map);
        Response response = this.parseSteps();
        ParamUtils.clear();
        return response;
    }
}
