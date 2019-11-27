package com.learn.testng.paramlearn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 参数化，多个值传递
 * */
public class DataProviderCase {

    @Test(dataProvider = "dataprovider1")
    public void dataProviderCase1(String name,int age){
        System.out.println("name:"+name+",age:"+age);
    }
    @DataProvider(name = "dataprovider1")
    public Object[][] dataProviderMethod(){
        Object[][] a = new Object[][]{
                {"闻宝",18},
                {"王陆",19},
                {"小海",17}
        } ;
        return a;
    }
    @Test(dataProvider = "dataMethod")
    public void dataProviderCase2(String name,int age){
        System.out.println("dataProviderCase2 方法："+"\n"+"name:"+name+",age:"+age);
    }
    @Test(dataProvider = "dataMethod")
    public void dataProviderCase3(String name,int age){
        System.out.println("dataProviderCase3 方法："+"\n"+"name:"+name+",age:"+age);
    }
    @DataProvider(name = "dataMethod")
    public Object[][] dataProviderMethod2(Method method){
        Object[][] object=null;
        if (method.getName().equals("dataProviderCase2")){
            object=new Object[][]{
                    {"王舞",200},{"风吟",1000},{"奥观海",200}
            };
        }else if (method.getName().equals("dataProviderCase3")){
            object=new Object[][]{
                    {"琉璃仙",20},{"周木木",18},{"风铃",300}
            };
        }
        return object;
    }

}
