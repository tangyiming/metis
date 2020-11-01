package com.tangym.common;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author backtym@live.cn
 */
public class CookiesManager {
    private static final Logger logger = LoggerFactory.getLogger(CookiesManager.class);
    /**
     * Using stored cookie to login into the application
     * NOTE: Use hard refresh in case you see the login page after executing the above script.
     * @param driver
     * @throws IOException
     */
    public static void fetchCookies(WebDriver driver) throws IOException {
        File file = new File("src/test/resources/Cookies.data");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(line, ";");
            while (token.hasMoreTokens()) {
                String name = token.nextToken();
                String value = token.nextToken();
                String domain = token.nextToken();
                String path = token.nextToken();
                Date expiry = null;
                String val;
                if (!(val = token.nextToken()).equals("null")) {
                    expiry = new Date(val);
                }
                Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                // This will add the stored cookie to your current session
                driver.manage().addCookie(ck);
            }
        }
    }

    /**
     * "Cookies.data" file stores all cookies information along with "Name, Value, Domain, Path".
     * We can retrieve this information and login into the application without entering the login credentials.
     * @param driver
     * @throws IOException
     */
    public static void storeCookies(WebDriver driver) throws IOException {
        File file = new File("src/test/resources/Cookies.data");
        if(file.exists() && !file.isDirectory()) {
            if(file.delete()){
                if(file.createNewFile()){
                    FileWriter fileWrite = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
                    for(Cookie ck : driver.manage().getCookies())
                    {
                        bufferedWriter.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    fileWrite.close();
                }else {
                    logger.error("Cookies.data文件创建失败");
                }
            }else{
                logger.error("Cookies.data文件删除失败");
            }
        }else{
            logger.error("Cookies.data文件不存在");
        }

    }

    /**
     * cookie basic operation
     * @param driver
     * @param cookie
     */

    public static void addCookie(WebDriver driver, Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    public static Cookie getNamedCookie(WebDriver driver, String name) {
        return driver.manage().getCookieNamed(name);
    }

    public static Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public static void deleteNamedCookie(WebDriver driver, String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public static void deleteCookieObject(WebDriver driver, Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    public static void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

}
