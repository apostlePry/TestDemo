package cn.study.utils;

import org.openqa.selenium.By;

import java.util.Map;

public class GetLocatorUtils {

    public static By getByLocator(Map<String, Object> map){
        for (String key : map.keySet()) {
            if ("id".equalsIgnoreCase(key)){
                return By.id(String.valueOf(map.get(key)));
            }else if ("xpath".equalsIgnoreCase(key)){
                return By.xpath(String.valueOf(map.get(key)));
            }else if ("css".equalsIgnoreCase(key)){
                return By.cssSelector(String.valueOf(map.get(key)));
            }else if ("text".equalsIgnoreCase(key)){
                return By.linkText(String.valueOf(map.get(key)));
            }else if ("partiallinktext".equalsIgnoreCase(key)){
                return By.partialLinkText(String.valueOf(map.get(key)));
            }else {
                throw new RuntimeException(" locator type not exist in this framework：" + key);
            }
        }
        return null;
    }
}
