/**
 * 
 */
package com.ganinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: CorsConfig 
 * @Description: TODO
 * @date 2019年1月23日 下午6:21:31
 * @version V1.0
 */
@Configuration  
public class CorsConfig extends WebMvcConfigurerAdapter{
	@Override    
    public void addCorsMappings(CorsRegistry registry) {    
        registry.addMapping("/**")    
                .allowedOrigins("*")    
                .allowCredentials(true)    
                .allowedMethods("GET", "POST", "DELETE", "PUT")    
                .maxAge(3600);    
    }    
}
