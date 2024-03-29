package com.zz.spring_demo1.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * Swagger2的接口配置
 *
 * @author hubiao
 */
@Configuration
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2 )
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo( apiInfo() )
                // 设置哪些接口暴露给Swagger展示
                .select()
                // (第一种方式)扫描所有有注解的api，用这种方式更灵活
                .apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class ) )
                // (第二种方式)扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.hubiao.pay.merchant.controller"))
                // (第三种方式)扫描所有
                //.apis(RequestHandlerSelectors.any())
                .paths( PathSelectors.any() )
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title( "标题：蚂蚁支付-商户应用API文档" )
                // 描述
                .description( "描述：向前端提供商户应用的ResultFul风格接口文档" )
                // 作者信息
                .contact( "hubiao" )
                // 版本
                .version( "版本号:" + "V1.0.0" )
                .build();
    }
}

