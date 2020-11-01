package com.tangym.common;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.tangym.utils.ExcelData;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author backtym@live.cn
 */
public class TestngListener extends TestListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(TestngListener.class);
    private String sheet;
    private String testcase;

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        try {
            BaseTest bt = (BaseTest) tr.getInstance();
            WebDriver driver = bt.getDriver();
            Method m = tr.getMethod().getMethod();
            if(m.isAnnotationPresent(Position.class)){
                sheet=m.getAnnotation(Position.class).sheet();
                testcase=m.getAnnotation(Position.class).testcase();
            }else{
                logger.error("请给测试方法"+tr.getName()+"添加@Position注解");
            }
            takeScreenShot(driver);
            logCaseStep();
            logExceptedResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取用例失败截图
     *
     * @param driver
     * @throws IOException
     */
    @Attachment(value = "失败截图", type = "image/png")
    public byte[] takeScreenShot(WebDriver driver) {
        byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }

    /**
     * 测试步骤
     */
    @Attachment(value = "操作步骤")
    public String logCaseStep() {
        String filePath = "src/test/resources/自动化测试用例.xlsx";
        ExcelData sheet1 = new ExcelData(filePath, sheet);
        return sheet1.getCellByCaseNum(testcase, 0, 6);
    }

    /**
     * 期望结果
     */
    @Attachment(value = "期望结果")
    public String logExceptedResult() {
        String filePath = "src/test/resources/自动化测试用例.xlsx";
        ExcelData sheet1 = new ExcelData(filePath, sheet);
        return sheet1.getCellByCaseNum(testcase, 0, 7);
    }


    //------------------------以下是失败用例重跑相关代码----------------------------------
    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);

        // List of test results which we will delete later
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
        // collect all id's from passed test
        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedTest : testContext.getPassedTests()
                .getAllResults()) {
//			logger.info("PassedTests = " + passedTest.getName());
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : testContext.getFailedTests()
                .getAllResults()) {
//			logger.info("failedTest = " + failedTest.getName());
            int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be
            // deleted
            // or delete this failed test if there is at least one passed
            // version
            if (failedTestIds.contains(failedTestId)
                    || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        // finally delete all tests that are marked
        for (Iterator<ITestResult> iterator = testContext.getFailedTests()
                .getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
//				logger.info("Remove repeat Fail Test: " + testResult.getName());
                iterator.remove();
            }
        }

    }

    private int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = id + result.getMethod().getMethodName().hashCode();
        id = id
                + (result.getParameters() != null ? Arrays.hashCode(result
                .getParameters()) : 0);
        return id;
    }
}
