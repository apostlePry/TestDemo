package test.request;

import java.util.HashMap;
import java.util.Map;

public class RequestHeader {
    private static RequestHeader requestHeader;
    private Map<String, Object> params = new HashMap<>();

    private RequestHeader(){}

    public static RequestHeader newInstance(){
        if (requestHeader == null){
            requestHeader = new RequestHeader();
        }
        return requestHeader;
    }

    public String getUserToken() {
        return String.valueOf(params.get("user-token"));
    }

    public void setUserToken(String userToken) {
        this.params.put("user-token", userToken);
    }

    public Object get(String key){
        return params.get(key);
    }

    public void put(String key, Object value){
        params.put(key, value);
    }

    public Map getMap(){
        return this.params;
    }

}
