package com.example.springboot03.system.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinchao
 * @date 2020/1/16 19:55
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean authFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加过滤器
        registration.setFilter(new WebFilter());
        // 设置过滤路径，/*所有路径
        registration.addUrlPatterns("/*");
        // 添加默认参数
        registration.addInitParameter("name", "value");
        registration.setName("preFilter");
        // 设置优先级
        registration.setOrder(1);
        registration.setEnabled(true);
        return registration;
    }

}
