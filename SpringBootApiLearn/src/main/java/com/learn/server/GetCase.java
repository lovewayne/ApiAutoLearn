package com.learn.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * GET方法的SwaggerUI实现方式
 * */
@RestController
@Api(value = "/",description = "这是全部get方法")
public class GetCase {
    /*返回cookies信息*/
    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可获取cookies",httpMethod = "GET")
    public String cookiesGet(HttpServletResponse response){
        // HttpServletRequest 装请求信息的类
        // HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "获取cookie成功";
    }

    /*要求携带cookies访问*/

    @RequestMapping(value = "/cookies/get",method = RequestMethod.GET)
    @ApiOperation(value = "要求携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookieList = request.getCookies();
        if (Objects.isNull(cookieList)){
            return  "请添加Cookies信息";
        }
        for (Cookie cookie : cookieList){

            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "携带cookies访问成功";
            }
        }
        return "必须携带cookies信息";
    }
    /**
     * 携带参数的get请求
     * 第一种实现方式：url/key=value&key=value
     * 例子：模拟获取商品列表的接口
     * */

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "携带参数的get请求的第一种实现方式",httpMethod = "GET")
    public Map<String,Integer> productList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> productMap = new HashMap<>();
        productMap.put("猪肉",35);
        productMap.put("牛肉",49);
        productMap.put("乌骨鸡",20);
        return  productMap;
    }
    /**
     * 第二种：携带参数的get请求
     * 格式：url:port/uri/{start}/{end}
     * 如：localhost:8090/get/with/param/10/20
     * */

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "携带参数的get请求的第二种实现方式",httpMethod = "GET")
    public Map<String,Double> produceList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Double> produceMap = new HashMap<>();
        produceMap.put("鹌鹑", 10.00);
        produceMap.put("草鱼",6.98);
        produceMap.put("雄鱼",7.98);
        return produceMap;
    }

}
