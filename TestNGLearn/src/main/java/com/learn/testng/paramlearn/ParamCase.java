package com.learn.testng.paramlearn;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 单个值传递，配置文件param.xml
 * */
public class ParamCase {

    @Test
    @Parameters({"name","age"})
    public void paramCase1(String name,int age){
        System.out.println("name:"+name+",age:"+age);
    }
}
