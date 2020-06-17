package test;

import test.api.BaseApi;
import test.pojo.CaseModel;
import test.pojo.TestCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class GetYamlTest {

    @Test
    public void yamlGetTest(){
        String path = "/test/api/UserApi.yaml";
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            CaseModel caseModel = mapper.readValue(BaseApi.class.getResourceAsStream(path), CaseModel.class);
            Map<String, TestCase> testcases = caseModel.getTestcases();
            for (String key : testcases.keySet()) {
                TestCase testCase = testcases.get(key);
                System.out.println(testCase);
                System.out.println(testCase.getParam());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
