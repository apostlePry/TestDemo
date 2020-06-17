package test.util;

import java.util.HashMap;
import java.util.Map;

public class ParamUtils {
    private static Map<String, Object> params = new HashMap<>();

    public static Map<String, Object> getParams() {
        return params;
    }

    public static void setParams(Map<String, Object> params) {
        ParamUtils.params = params;
    }

    public static String replace(String dataRow) {
        for (Map.Entry<String, Object> kv : params.entrySet()) {
            String matcher = "${" + kv.getKey() + "}";
            if (dataRow.contains(matcher)) {
                dataRow = dataRow.replace(matcher, kv.getValue().toString());
            }
        }
        return dataRow;
    }

    public static void clear(){
        params.clear();
    }

    public static void main(String[] args) {
        params.put("userId", "123");
        System.out.println(replace("${userId}"));
    }
}
