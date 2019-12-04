package com.learn.extents;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
/**
 * 断言，日志
 * */
public class ExtentsCases {
    @Test
    public void extentsCase1(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void extentsCase2(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void extentsCase3(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void logCase(){
        Reporter.log("logCase");
        throw new RuntimeException("抛出异常日志");
    }
}
