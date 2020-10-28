package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com/example/demo/controller"))
                .paths(PathSelectors.any()).build();
    }

    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("luohz接口文档")
                .description("swagger接口文档演示")
                .version("1.0")
                .license("mit")
                .licenseUrl("www.luohz.com")
                .termsOfServiceUrl("https://www.cnblogs.com/luohz")
                .build();
    }
}
