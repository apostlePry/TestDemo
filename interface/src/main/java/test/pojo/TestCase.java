package test.pojo;

import java.io.Serializable;
import java.util.Map;

public class TestCase implements Comparable<TestCase>, Serializable {
    /*
     * 是否开启
     * 是可以执行，
     * 否则不被执行
     */
    private boolean run;

    /*
     *用例名称
     */
    private String caseName;

    /*
     * 类型
     * http请求类型一般为get，post
     */
    private String type;

    /*
     * 请求地址
     */
    private String url;

    /*
     * 请求顺序，按照由小到大顺序执行
     */
    private Integer sort;

    /**
     * 请求参数，一般只有post请求有，get请求参数在url后
     */
    private Map<String, Object> param;

    private Map<String, Object> header;

    private String postJson;

    private String checkPoint;

    private String result;

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public String getPostJson() {
        return postJson;
    }

    public void setPostJson(String postJson) {
        this.postJson = postJson;
    }

    public String getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(String checkPoint) {
        this.checkPoint = checkPoint;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "run=" + run +
                ", caseName='" + caseName + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", params='" + param + '\'' +
                ", header='" + header + '\'' +
                ", postJson='" + postJson + '\'' +
                ", checkPoint='" + checkPoint + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public int compareTo(TestCase o) {
        return this.sort - o.getSort();
    }

}
