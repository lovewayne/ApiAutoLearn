package com.learn.testng.timeOut;

import org.testng.annotations.Test;

public class TimeOutCase {
    @Test(timeOut = 3000)
    public void timeOutCase1() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    public void timeOutCase2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
