package pageobject;

import com.tangym.common.OperateElement;
import org.openqa.selenium.WebElement;


/**
 * @author backtym@live.cn
 */
public class BaiduSearchPage {

    /**
     * 搜索框
     *
     * @return
     */
    public static WebElement searchInput() {
        return OperateElement.waitById("kw");
    }

    /**
     * 百度一下 按钮
     *
     * @return
     */
    public static WebElement searchBtn() {
        return OperateElement.waitById("su");
    }

    /**
     * 搜索结果的第几行
     *
     * @param row 第几行
     * @return
     */
    public static WebElement searchResult(int row) {
        String xpath = "//*[@id='" + row + "']/h3/a";
        return OperateElement.waitByXpath(xpath);
    }

    /**
     * 搜索操作
     *
     * @param keywords
     */
    public static void search(String keywords) {
        searchInput().clear();
        searchInput().sendKeys(keywords);
        searchBtn().click();
    }
}
