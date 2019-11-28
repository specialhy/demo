package com.ganinfo.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${server.address:127.0.0.1}")
	private String address;
	@Value("${server.port:8081}")
	private String port;

	 @Bean
	    public Docket createRestApi() {
		 Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
	            public boolean apply(RequestHandler input) {
	                Class<?> declaringClass = input.declaringClass();
	                if (declaringClass == BasicErrorController.class) {// 排除
						return false;
					}
	                if(declaringClass.isAnnotationPresent(RestController.class)) { // 被注解的类
						return true;
					}
	                if(input.isAnnotatedWith(ResponseBody.class)) { // 被注解的方法
						return true;
					}
	                return false;
	            }
	        };
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .useDefaultResponseMessages(false)
	                .select()
	                .apis(predicate)
	                .build();
	    }

	    @SuppressWarnings("deprecation")
		private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("swagger-bootstrap-ui RESTful APIs")//大标题
	            .description("swagger-bootstrap-ui")
	            .termsOfServiceUrl("http://"+address+":"+port+"/")
	            .contact("--")
	            .version("1.0")//版本
	            .build();
	    }

}
