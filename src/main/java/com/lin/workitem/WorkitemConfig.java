package com.lin.workitem;

import com.lin.workitem.common.LoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WorkitemConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler中的是访问路径，可以修改为其他的字符串
        //addResourceLocations中的是实际路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/h_ui/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void  addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login**")
                .excludePathPatterns("/getVcode");
        super.addInterceptors(interceptorRegistry);
    }
}
