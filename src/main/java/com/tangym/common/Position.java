package com.tangym.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 定位关联测试方法与用例，便于获取用例步骤与预期内容填充测试报告
 * @author backtym@live.cn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Position {
    //sheet name
    String sheet() default "";
    //test case number
    String testcase() default "";
}
