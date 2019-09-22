package com.robesz.restlogfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestlogfilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestlogfilterApplication.class, args);
    }


    @Bean
    public FilterRegistrationBean<LogFilter_Common> logFilterCommon(){

        FilterRegistrationBean<LogFilter_Common> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LogFilter_Common());
        registrationBean.addUrlPatterns("/rest/second");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LogFilter_First> logFilterFirst(){

        FilterRegistrationBean<LogFilter_First> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LogFilter_First());
        registrationBean.addUrlPatterns("/rest/first");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LogFilter_Second> logFilterSecond(){

        FilterRegistrationBean<LogFilter_Second> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LogFilter_Second());
        registrationBean.addUrlPatterns("/rest/second");

        return registrationBean;
    }


}
