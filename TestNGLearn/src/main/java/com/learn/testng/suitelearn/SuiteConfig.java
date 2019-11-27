package com.learn.testng.suitelearn;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
/**
 * suite套件测试，执行顺序
 * */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite套件前");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite套件后");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest执行");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest执行");
    }
}
