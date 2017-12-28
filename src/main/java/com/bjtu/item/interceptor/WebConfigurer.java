package com.bjtu.item.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bestv on 2017/8/15.
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("**/static/**")
//                .addResourceLocations("/Users/zhaojun/Documents/project/item/src/main/resources/static/");
//        .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
