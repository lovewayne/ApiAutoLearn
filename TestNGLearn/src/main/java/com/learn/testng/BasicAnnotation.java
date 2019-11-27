package com.learn.testng;


import org.testng.annotations.*;
/**
* 组件执行顺序
 * BeforeSuite --> BeforeClass --> BeforeMethod --> AfterMethod --> AfterClass --> AfterSuite
*/
public class BasicAnnotation {
    /*最基本的注解，用来把方法标记成测试的一部分*/
    @Test
    public void testCase1(){
        System.out.println("这是testCase1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是TestCase2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BasicAnnotation之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("BasicAnnotation之后运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}
