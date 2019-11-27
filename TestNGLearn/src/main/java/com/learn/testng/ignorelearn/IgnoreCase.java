package com.learn.testng.ignorelearn;

import org.testng.annotations.Test;

/**
 * 忽略测试，即Test的enabled属性，默认true
 * */
public class IgnoreCase {
    @Test
    public void ignoreCase1(){
        System.out.println("ignoreCase1执行");
    }
    @Test(enabled = false)
    public void ignoreCase2(){
        System.out.println("ignoreCase2执行");
    }
    @Test(enabled = true)
    public void ignoreCase3(){
        System.out.println("ignoreCase3执行");
    }
}
