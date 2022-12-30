package com.thinktown.conrad2022.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 2 自动生成文档
 * http://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinktown.conrad2022.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Conrad 2022")
                .contact(new Contact("Thinktown", "https://www.thinktown.com", "lisonglin@thinktown.com"))
                .description("API Doc for Conrad 2022 Mindmap project")
                .version("0.0.1")
                .build();
    }
}
