package cases;

import com.tangym.common.BaseTest;
import com.tangym.common.OperateElement;
import com.tangym.common.Position;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.BaiduSearchPage;


/**
 * @author backtym@live.cn
 */
public class BaiduTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() { }

    @Test
    @Position(sheet="搜索", testcase="tc001")
    public void testBaiduSearch() {
        String baiduUrl = envProperties.getProperty("baidu.url");
        String keywords = envProperties.getProperty("keywords");
        driver.get(baiduUrl);
        BaiduSearchPage.search(keywords);
        BaiduSearchPage.searchResult(1).click();
        //切换到第二个窗口
        OperateElement.switchToWindowByIndex(1);
        //获取博客页的titleName
        String titleName = OperateElement.waitByXpath("//h1").getText().trim();
        //验证titleName是否正确
        Assert.assertTrue(titleName.contains("阮一峰的个人网站"), "title不对，显示的是:" + titleName);
    }
}
