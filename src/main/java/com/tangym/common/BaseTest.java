package com.tangym.common;

import com.tangym.utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.Properties;


/**
 * @author backtym@live.cn
 */
@Listeners({TestngListener.class})
public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver driver;
    public Properties envProperties;
    public WebDriver getDriver() {
       return driver;
    }

    @BeforeClass
    public void setUp() throws IOException {
        String browser = System.getProperty("browser");
        if(null == browser){
            //调试代码使用 TODO 上线前修改代码逻辑
//            browser = "chrome";
            logger.error("请在执行命令中提供目的运行浏览器参数信息：-Dbrowser=chrome/firefox/edge");
            System.exit(1);
        }

        switch (browser.toLowerCase()){
            case "chrome":
                driver = InitDriver.launchChromeDriver();
                OperateElement.driver = driver;
                break;
            case "firefox":
                driver = InitDriver.launchFirefoxDriver();
                OperateElement.driver = driver;
                break;
            case "edge":
                driver = InitDriver.launchEdgeDriver();
                OperateElement.driver = driver;
                break;
            default:
                logger.error("请在执行命令中提供正确的目的运行浏览器参数信息：-Dbrowser=chrome/firefox/edge");
                System.exit(1);
                break;

        }
        envProperties = ReadProperties.readProperties("env.properties");
    }

    /**
     * 一个测试执行完毕后关闭浏览器
     * enabled = true || false 进行控制
     */
    @AfterClass(enabled = true)
    public void tearDown() {
        driver.quit();
        logger.info("退出 web driver");
    }

}
