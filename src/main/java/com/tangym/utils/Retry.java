package com.tangym.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * @author backtym@live.cn
 */
public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
