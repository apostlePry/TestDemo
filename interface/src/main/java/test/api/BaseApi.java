package test.api;

import test.pojo.CaseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.restassured.response.Response;

import java.io.IOException;

public class BaseApi {
    private CaseModel cases = new CaseModel();

    public CaseModel getCases() {
        return cases;
    }

    public void setCases(CaseModel cases) {
        this.cases = cases;
    }

    public Response parseSteps(){
        String caseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (cases.getTestcases().entrySet().isEmpty()){
            String path = "/" + this.getClass().getCanonicalName().replace(".", "/") + ".yaml";
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                cases = mapper.readValue(BaseApi.class.getResourceAsStream(path), CaseModel.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cases.excute(caseName);
    }
}
