package com.tangym.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author backtym@live.cn
 */
public class OperateElement {
    private static final Logger logger = LoggerFactory.getLogger(OperateElement.class);

    public static WebDriver driver;
    private static final int TIME_OUT_IN_SECONDS = 3;

    private OperateElement() {
    }

    /**
     * 通过元素的Xpath，等待元素的出现,返回此元素
     *
     * @return 返回等待的元素
     */
    public static WebElement waitByXpath(String xpath) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * 通过元素的name，等待元素的出现,返回此元素
     *
     * @param name 元素的name
     * @return 返回等待的元素
     */
    public static WebElement waitByName(String name) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
    }

    /**
     * 通过元素的id，等待元素的出现,返回此元素
     *
     * @param id 元素的id
     * @return 返回等待的元素
     */
    public static WebElement waitById(String id) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    /**
     * 通过元素的linkText，等待元素的出现,返回此元素
     *
     * @param linkText 元素的linkText
     * @return 返回等待的元素
     */
    public static WebElement waitByLinkText(String linkText) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
    }

    /**
     * 通过元素的className，等待元素的出现,返回此元素
     *
     * @param className 元素的className
     * @return 返回等待的元素
     */
    public static WebElement waitByClassName(String className) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

    /**
     * 通过元素的Css，等待元素的出现,返回此元素
     *
     * @return 返回等待的元素
     */
    public static WebElement waitByCss(String css) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
    }

    /**
     * 通过元素的某个属性，等待元素的出现,返回此元素
     *
     * @param attribute 属性名
     * @param value     属性值
     * @return web元素
     */
    public static WebElement waitByAttribute(String attribute, String value) {
        String xpath = "//*[@" + attribute + "='" + value + "']";
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * 通过html某个标签中间的text,等待元素的出现,返回此元素
     *
     * @param text
     * @return
     */
    public static WebElement waitByText(String text) {
        String xpath = "//*[text()='" + text + "']";
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * 通过元素的className，等待元素列表的出现,返回此元素列表
     *
     * @param className 元素的className
     * @return 返回等待的元素
     */
    public static List<WebElement> waitElementsByClassName(String className) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.className(className))));
    }

    /**
     * 通过元素的linkText，等待元素列表的出现,返回此元素列表
     *
     * @param linkText 元素的linkText
     * @return 返回等待的元素
     */
    public static List<WebElement> waitElementsByLinkText(String linkText) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.linkText(linkText))));
    }

    /**
     * 通过元素的xpath，等待元素列表的出现,返回此元素列表
     *
     * @param xpath
     * @return
     */
    public static List<WebElement> waitElementsByXpath(String xpath) {
        return new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(xpath))));
    }

    /**
     * 通过元素的linkText，等待元素的出现,并点击它
     *
     * @param linkText
     */
    public static void clickByLinkText(String linkText) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        targetElement.click();
    }

    /**
     * 通过元素的Xpath，等待元素的出现,并点击它
     *
     * @param xpath
     */
    public static void clickByXpath(String xpath) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        targetElement.click();
    }

    /**
     * 通过元素的Xpath，等待元素的出现,并点击它
     *
     * @param css
     */
    public static void clickByCss(String css) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
        targetElement.click();
    }


    /**
     * 通过元素的ID，等待元素的出现,并点击它
     *
     * @param Id
     */
    public static void clickById(String Id) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.id(Id)));
        targetElement.click();
    }

    /**
     * 通过元素的ClassName，等待元素的出现,并点击它
     *
     * @param className
     */
    public static void clickByClassName(String className) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.className(className)));
        targetElement.click();
    }

    /**
     * 通过元素的Name，等待元素的出现,并点击它
     *
     * @param name
     */
    public static void clickByName(String name) {
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.name(name)));
        targetElement.click();
    }

    /**
     * 通过元素的某个特定属性，等待元素的出现,并点击它
     *
     * @param attribute 属性
     * @param value     属性值
     */
    public static void clickByAttribute(String attribute, String value) {
        String xpath = "//*[@" + attribute + "='" + value + "']";
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        targetElement.click();
    }

    /**
     * 通过html某个标签中间的text找到元素,并点击它
     *
     * @param text
     */
    public static void clickByText(String text) {
        String xpath = "//*[text()='" + text + "']";
        WebElement targetElement = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        targetElement.click();
    }

    /**
     * 用javaScript执行点击事件
     *
     * @param
     * @author guilin_cui
     */
    public static void clickByJS(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
    }

    /**
     * 用javaScript执行点击事件
     *
     * @param by 传入定位
     */
    public static void clickByJSBy(By by) {
        WebElement ele = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
    }

    /**
     * 通过元素的Xpath，等待文本框的出现,并输入
     */
    public static void sendKeysByXpath(String xpath, String keys) {
        WebElement targetElement = waitByXpath(xpath);
        targetElement.clear();
        targetElement.sendKeys(keys);
    }

    /**
     * 指定元素，再输入
     *
     * @param element
     * @param keys
     */
    public static void sendKeysByEle(WebElement element, String keys) {
        element.clear();
        element.sendKeys(keys);
    }

    /**
     * 通过元素的ID，等待文本框的出现,并输入
     */
    public static void sendKeysById(String Id, String keys) {
        WebElement targetElement = waitById(Id);
        targetElement.clear();
        targetElement.sendKeys(keys);
    }

    /**
     * 通过元素的name，等待文本框的出现,并输入
     */
    public static void sendKeysByName(String name, String keys) {
        WebElement targetElement = waitByName(name);
        targetElement.clear();
        targetElement.sendKeys(keys);
    }

    /**
     * 通过元素的ClassName，等待文本框的出现,并输入
     */
    public static void sendKeysByClassName(String className, String keys) {
        WebElement targetElement = waitByClassName(className);
        targetElement.clear();
        targetElement.sendKeys(keys);
    }

    /**
     * 用javaScript输入
     */
    public static void sendKeysByJS(WebElement ele, String keys) {
        String str = "arguments[0].value='" + keys + "';";
        ele.clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(str, ele);
    }

    /**
     * 等待元素可见
     *
     * @param ele
     * @param waitTime
     */
    public static void waitEleVisible(WebElement ele, int waitTime) {
        new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(ele));
    }

    /**
     * 等待元素可点击
     *
     * @param ele
     * @param waitTime
     */
    public static void waitEleCanClickable(WebElement ele, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(ele));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    /**
     * 拖动元素
     *
     * @param element 元素
     * @param xOffset 拖到目标的横坐标位置，xOffset为正数时向右移动，为负数时向左移动
     * @param yOffset 拖到目标的纵坐标位置
     */
    public static void dragAndDropBy(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
    }

    /**
     * 拖动滚动条到目标元素的位置
     */
    public static void scrollIntoView(WebElement target) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
    }

    /**
     * 鼠标悬停
     *
     * @param ele 元素
     * @param ms  悬停时间(毫秒)
     */
    public static void mouthHover(WebElement ele, int ms) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        threadSleep(ms);
    }

    /**
     * 鼠标点击并悬停
     */
    public static void clickAndHold(WebElement ele) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(ele).perform();
    }

    /**
     * 双击
     */
    public static void doubleClick(WebElement ele) {
        Actions builder = new Actions(driver);
        builder.doubleClick(ele).perform();
    }

    /**
     * 判断元素是否存在
     *
     * @param ele 等待的元素
     * @return boolean 是否存在
     */
    public static boolean isElementExits(WebElement ele) {
        boolean flag;
        try {
            WebElement element = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(ele));
            flag = element.isDisplayed();
        } catch (Exception e) {
            flag = false;
            logger.error("Element:" + ele.toString() + " is not exits!");
        }
        return flag;
    }

    /**
     * 判断元素是否存在
     *
     * @param locator 如：By.id("")
     * @return boolean 是否存在
     */
    public static boolean isElementExitsBy(By locator) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
            flag = true;
        } catch (NoSuchElementException e) {
            logger.error("Element:" + locator.toString() + " is not exits!");
        }
        return flag;
    }

    /**
     * 通过点击一个元素来切换窗口
     *
     * @param element 被点击的元素
     */
    public static void switchToWindowByClick(WebElement element) {
        String currentWindow = driver.getWindowHandle();
        element.click();
        threadSleep(3000);
        Set<String> windowHandles = driver.getWindowHandles();
        //切换窗口
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    /**
     * 通过窗口的索引来切换窗口,index从0开始
     *
     * @param index
     */
    public static void switchToWindowByIndex(int index) {
        try {
            List<String> windowHandles = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(index));
        } catch (IndexOutOfBoundsException var3) {
            var3.printStackTrace();
        }
    }

    /**
     * 通过窗口名称来切换窗口
     *
     * @param windowTitleName 窗口名称
     */
    public static void switchToWindowHandle(String windowTitleName) {
        Set<String> handles = driver.getWindowHandles();
        List<String> it = new ArrayList<>(handles);
        Iterator<String> iterator = handles.iterator();
        String currentHandle = null;
        try {
            currentHandle = driver.getWindowHandle();
        } catch (NoSuchWindowException e) {
            driver.switchTo().window(it.get(0));
        }
        while (iterator.hasNext()) {
            String h = iterator.next();
            String currentTitle = driver.getTitle();
            if (currentTitle.contains(windowTitleName)) {
                break;
            }
            if (!h.equals(currentHandle)) {
                if (driver.switchTo().window(h).getTitle().contains(windowTitleName)) {
                    driver.switchTo().window(h);
                    logger.info("switch to " + driver.getTitle() + " news page successfully");
                    break;
                }
            }
        }
    }

    /**
     * 关闭除了第一个窗口外的其它窗口
     */
    public static void closeWindowHandleNotFirst() {
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            for (int i = windowHandles.size() - 1; i > 0; i--) {
                driver.close();
                switchToWindowByIndex(i - 1);
            }
        }
    }

    /**
     * 通过frame的ID切换iframe
     */
    public static void switchToFrameById(String id) {
        WebElement frame = driver.findElement(By.id(id));
        driver.switchTo().frame(frame);
    }

    /**
     * 切换iframe
     */
    public static void switchToFrameByEle(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }



    /**
     * 等待 alert出现
     *
     * https://www.selenium.dev/documentation/en/webdriver/js_alerts_prompts_and_confirmations/
     */
    public static Alert waitForAlert(String alertName) {
        Alert targetAlert = null;
        try {
            targetAlert = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            logger.warn("没有找到目标元素--" + alertName);
        }
        return targetAlert;
    }

    /**
     * alert 确认
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception ignored) {
        }
    }

    /**
     * alert 取消
     */
    public static void dissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception ignored) {
        }
    }

    /**
     * 打开新的窗口，并切换到该窗口
     *
     * @param url        新窗口的url
     * @param windowName 窗口title
     */
    public static void openWindow(String url, String windowName) {
        String js = "window.open(\"" + url + "\")";
        ((JavascriptExecutor) driver).executeScript(js);
        switchToWindowHandle(windowName);
    }

    /**
     * 线程等待
     * @param timeout 单位：毫秒
     */
    public static void threadSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 打开url，一直等到页面的readyState为“complete",注意readyState=complete时并不意味着url全部加载完毕，只是这时我们的页面元素可以操作了
     */
    public static void getUrlUntilLoadComplete(String url) {
        driver.get(url);
        for (int i = 0; i < 5; i++) {
            if ("complete".equals(((JavascriptExecutor) driver).executeScript("return document.readyState"))) {
                break;
            }
            threadSleep(1000);
            //如果等了5秒还没有加载完，停止加载，往后执行代码
            if (i == 4) {
                ((JavascriptExecutor) driver).executeScript("window.stop();");
            }
        }
    }
}

