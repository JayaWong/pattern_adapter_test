package com.jaya;

import com.jaya.adapter.XmlProperties;
import java.util.Map;
import java.util.Set;

/**
 * @author wangjianying
 * @Title: Main
 * @Description: ${END}
 * @date 2019/3/3118:09
 */
public class Main {
    public static void main(String[] args) {
        XmlProperties xp = new XmlProperties();
        xp.load("target/classes/properties/test-properties.xml");
        Set<Map.Entry<Object, Object>> entries = xp.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey()+ ":" + entry.getValue());
        }
    }
}
