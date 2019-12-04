package com.learn.server;

import com.learn.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Post方法的SwaggerUI实现方式
 * */

@RestController
@RequestMapping("/post")
@Api(value = "/",description = "这是模拟Post请求")
public class PostCase {

    private Cookie cookie;
    private User user;

    /**
     * 设置cookie访问并获取cookie
     * 方法体中携带参数故用Jmeter测试时需要在HTTP请求中用Parameters添加参数
     * */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "这是post登录方法,成功获取cookie",httpMethod = "POST")
    public String loginCase(HttpServletResponse response,
                            @RequestParam(value = "用户名",required = true) String userName,      // value:描述,required:必须输入
                            @RequestParam(value = "密码",required = true) String passwd){       // value:描述,required:必须输入
        if (userName.equals("wayne")&&passwd.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "登陆成功！";
        }

        return "用户名或密码错误";
    }
    /**
     * 登录后获取用户列表
     * 单独运行此方法时，SwaggerUI报500错误，用Jmeter测试时需要在HTTPCookies管理器中添加cookies信息
     * 因方法体中的RequestBody是json格式的参数，用Jmeter测试时需在取样器的HTTP请求中用BodyData添加json信息
     * */
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,@RequestBody User user){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")
                    && user.getUserName().equals("wayne") &&user.getPasswd().equals("123456")){
                user.setName("Nicky");
                user.setAge("20");
                user.setHobby("羽毛球");
                return user.toString();
            }
        }
        return "参数验证不合法";
    }

}
