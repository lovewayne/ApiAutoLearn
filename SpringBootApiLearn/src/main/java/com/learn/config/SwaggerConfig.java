package com.learn.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())  // 增加方法信息
                .pathMapping("/")    // 根路径
                .select()
                .paths(PathSelectors.regex("/.*")) // 正则匹配方法路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的API接口文档")   //标题
                .contact(new Contact("wayne","","waynelikeu@gmail.com")) // 内容
                .description("这是SwaggerUI生成的文档")     // 描述
                .version("1.0.0")       // 版本号
                .build();
    }
    /*运行Application.java,访问路径：http://localhost:8090/swagger-ui.html*/

}
