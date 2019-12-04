package com.learn.httpclient.com.learn.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetCookiesCase {
    private String url;
    private ResourceBundle bundle;

    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        // 默认加载properties文件，且必须声明编码格式
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("basic.url");
    }

    @Test
    public void getCookies() throws IOException {
        // 用于存储结果
        String result;
        String uri = bundle.getString("getcookies.uri");
        // 逻辑获取json响应信息
        HttpGet get = new HttpGet(this.url + uri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        // 获取响应的cookies值
        store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie e : cookies) {
            String name = e.getName();
            String value = e.getValue();
            System.out.println("cookie:name=" + name + ",value=" + value);
        }

    }
    @Test(dependsOnMethods = {"getCookies"})
    public void cookiesGet() throws IOException {
        String uri = bundle.getString("case.cookies.get");
        HttpGet get = new HttpGet(this.url+uri);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        // 获取状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }



    }
}