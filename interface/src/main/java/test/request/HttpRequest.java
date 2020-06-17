package test.request;

import test.util.ParamUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class HttpRequest {
    private RequestSpecification request = RestAssured.given();

    public Response doGet(String url, Map<String, Object> param, Map<String, Object> headers){
        if (param != null){
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                request.queryParam(entry.getKey(), ParamUtils.replace(String.valueOf(entry.getValue())));
            }
        }

        return getResponse("get", headers, url);
    }

    public Response doPost(String url, Map<String, Object> param, Map<String, Object> headers){
        if (param != null){
            param.entrySet().forEach(entry -> param.put(entry.getKey(),
                    ParamUtils.replace(String.valueOf(entry.getValue())))
            );
            request.body(param).contentType(ContentType.JSON);
        }

        return getResponse("post", headers, url);
    }

    public Response doPostJson(String url, Map<String, Object> param, Map<String, Object> headers){
        if (param != null){
            param.entrySet().forEach(entry -> param.put(entry.getKey(),
                    ParamUtils.replace(String.valueOf(entry.getValue())))
            );
            request.body(param).contentType(ContentType.JSON);
        }

        return getResponse("post", headers, url);
    }

    public Response delete(String url, Map<String, Object> param, Map<String, Object> headers){
        if (param != null){
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                param.put(entry.getKey(), ParamUtils.replace(String.valueOf(entry.getValue())));
            }
            request.body(param).contentType(ContentType.JSON);
        }

        return getResponse("delete", headers, url);
    }

    private Response getResponse(String method, Map<String, Object> headers, String url) {
        if (headers != null){
            for (Map.Entry<String, Object> entry : headers.entrySet()){
                request.header(entry.getKey(), ParamUtils.replace(String.valueOf(entry.getValue())));
            }
        }
        Response response = request.when().log().all().request(method, url);
        return response.then().log().all().extract().response();
    }
}
