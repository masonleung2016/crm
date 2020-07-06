package com.ufostudio.crm.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:35
 * @Package: com.ufostudio.crm.common.config
 */


@Configuration
@EnableSwagger2
@ComponentScan (basePackages = {"cn.hang.crm.modules.api.controller"})
public class SwaggerConfig {

    /* @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }*/

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

   /* @Bean
    public Docket customDocket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("apiGroup1").apiInfo(apiInfo()).select()
                .paths(PathSelectors.ant("/sys*/

    /**
     * ")).build();
     * }
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CRM系统")
                .description("CRM系统")
                .termsOfServiceUrl("")
                .contact("peanut")
                .version("1.0.0").build();
    }
}
