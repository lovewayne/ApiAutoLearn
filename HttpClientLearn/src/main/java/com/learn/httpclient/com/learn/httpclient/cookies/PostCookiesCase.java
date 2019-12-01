package com.learn.httpclient.com.learn.httpclient.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PostCookiesCase {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("basic.url");
    }
    @Test
    public void getCookies() throws IOException {
        String result;
        String uri = bundle.getString("getcookies.uri");
        String caseurl = this.url+uri;
        HttpGet get = new HttpGet(caseurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();
        for (Cookie cookie : cookiesList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie:name="+name+",value="+value);
        }
    }
    @Test(dependsOnMethods = "getCookies")
    public void postCookieCase() throws IOException {

        // 拼接地址
        String uri=bundle.getString("case.post.cookies");
        String caseurl=this.url+uri;
        //声明一个post对象
        HttpPost httpPost = new HttpPost(caseurl);

        // 声明一个client对象
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        // 添加参数
        JSONObject param = new JSONObject();
        param.put("name","wangwu");
        param.put("age","200");

        // 设置请求头信息,header
        httpPost.setHeader("content-type","application/json");
        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);
        // 声明一个对象进行响应结果的存储
        String result;

        // 设置cookies信息
        defaultHttpClient.setCookieStore(this.store);
        // 执行post方法
        HttpResponse httpResponse = defaultHttpClient.execute(httpPost);
        httpResponse.setHeader("content-type","text/html;charset=gbk");
        // 获取响应结果
        result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println(result);

        // 处理结果，判断结果是否符合预期
        // 将返回的响应结果转化为json对象
        JSONObject reslutJSON = new JSONObject(result);

        // 获取到结果的值
        String name = (String) reslutJSON.get("name");
        String age = (String) reslutJSON.get("age");
        int status = (int) reslutJSON.get("status");

        // 具体判断返回的结果的值
        Assert.assertEquals("王陆",name);
        Assert.assertEquals("18",age);
        Assert.assertEquals(2,status);

    }
}
