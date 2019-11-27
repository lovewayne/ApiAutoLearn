package com.learn.testng.mutilThread;

import org.testng.annotations.Test;

/**
 * 多线程传参，注解可指定线程池数
 * */
public class MutilThreadOnAnnotation {
    /*
    * invocationCount 用例数
    * threadPoolSize 线程池数
    * */
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void mutilThreadOnAnnotationCase(){
        System.out.println("Thread_id:"+Thread.currentThread().getId());
    }
}
