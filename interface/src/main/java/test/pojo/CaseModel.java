package test.pojo;

import test.request.HttpRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CaseModel {
    private Map<String, TestCase> testcases = new HashMap<>();

    public Map<String, TestCase> getTestcases() {
        return testcases;
    }

    public void testcase(Map<String, TestCase> testcases) {
        this.testcases = testcases;
    }

    public TestCase getTestCase(String caseName){
        return testcases.get(caseName);
    }

    public Response excute(String caseName){
        HttpRequest request = new HttpRequest();
        Response response = null;
        TestCase testCase = getTestCase(caseName);
        if ("get".equalsIgnoreCase(testCase.getType())){
            response = request.doGet(testCase.getUrl(), testCase.getParam(), testCase.getHeader());
        }else if ("post".equalsIgnoreCase(testCase.getType())){
            response = request.doPost(testCase.getUrl(), testCase.getParam(), testCase.getHeader());
        }else if("delete".equalsIgnoreCase(testCase.getType())){
            response = request.delete(testCase.getUrl(), testCase.getParam(), testCase.getHeader());
        }else if ("post_json".equalsIgnoreCase(testCase.getType())){

        }
        return response;
    }
}
