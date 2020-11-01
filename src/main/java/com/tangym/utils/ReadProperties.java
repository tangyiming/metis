package com.tangym.utils;

import java.io.*;
import java.util.Properties;


/**
 * @author backtym@live.cn
 */
public class ReadProperties {

    /**
     * 读取properties文件
     *
     * @param fileName 文件名
     * @return 返回Properties
     */
    public static Properties readProperties(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/test/resources/"+fileName));
            //GBK 解决中文乱码
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "GBK"));
            properties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 通过key读取properties文件里的value
     *
     * @param fileName 文件名
     * @param key
     * @return 对应的value
     */
    public static String readPropertiesByKey(String fileName, String key) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/test/resources/"+fileName));
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "GBK"));
            properties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.get(key).toString();
    }

    public static void main(String[] args) {
        Properties properties2 = readProperties("env.properties");

        System.out.println(properties2.getProperty("baidu.url"));
    }
}
