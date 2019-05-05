package com.syx.bytcrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置Swagger2
 *
 * @author 牛东峰
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建RESTful文档
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            // 加了ApiOperation注解的类，才生成接口文档
            //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .apis(RequestHandlerSelectors.basePackage("com.syx.bytcrm.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    /**
     * 创建接口文档的基本信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("圣源祥项目API文档")
                .termsOfServiceUrl("https://www.baidu.com/")
                .version("1.0.0")
                .build();
    }

}
