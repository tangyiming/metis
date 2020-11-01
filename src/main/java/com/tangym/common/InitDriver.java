package com.tangym.common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;

/**
 * @author backtym@live.cn
 */
public class InitDriver {
    /**
     * 初始化 EdgeDriver
     */
    public static EdgeDriver launchEdgeDriver() throws IOException {
        File directory = new File(".");
        System.setProperty("webdriver.edge.driver", directory.getCanonicalPath() + "/../webdrivers/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(String.valueOf(PageLoadStrategy.NONE));
        EdgeDriver driver = new EdgeDriver(edgeOptions);
        return driver;
    }

    /**
     * 初始化 ChromeDriver
     */
    public static ChromeDriver launchChromeDriver() throws IOException {
        File directory = new File(".");
        System.setProperty("webdriver.chrome.driver", directory.getCanonicalPath() + "/../webdrivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }


    /**
     * 初始化 FirefoxDriver
     */
    public static FirefoxDriver launchFirefoxDriver() throws IOException {
        File directory = new File(".");
        System.setProperty("webdriver.gecko.driver", directory.getCanonicalPath() + "/../webdrivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }
}
