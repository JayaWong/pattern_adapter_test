package com.jaya.adapter;

import com.jaya.handler.XmlReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author wangjianying
 * @Title: XmlProperties
 * @Description: 对象适配器
 * @date 2019/3/3118:10
 */
public class XmlProperties extends Properties {

    //适配一个xml解析器
    private XmlReader xmlReader;

    public void load(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            this.xmlReader = new XmlReader(this,fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
