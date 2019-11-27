package com.learn.testng.mutilThread;

import org.testng.annotations.Test;

public class MutilThreadOnXml {
    @Test
    public void mutilThreadOnXmlCase1(){
        System.out.println("Thread_id:"+Thread.currentThread().getId());
    }
    @Test
    public void mutilThreadOnXmlCase2(){
        System.out.println("Thread_id:"+Thread.currentThread().getId());
    }
    @Test
    public void mutilThreadOnXmlCase3(){
        System.out.println("Thread_id:"+Thread.currentThread().getId());
    }
}
