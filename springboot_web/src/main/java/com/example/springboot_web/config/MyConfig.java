package com.example.springboot_web.config;

import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * ClassName MyConfig
 * Description TODO
 * Author 11931
 * Date 2022-10-06:1:10
 * Version 1.0
 **/


// WebMvcConfigurer 是MVC的配置规则接口，因为里面有很多的默认实现，所以实现接口的时候不需要实现所有的方法（基于jdk1.8以上）
@Configuration
public class MyConfig implements WebMvcConfigurer {

    // 如何把_method 这个名字换成我们自己喜欢的。
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        // 创建这个对象
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    // 开启矩阵变量的方法一： 实现WebMvcConfigurer接口，并且重写configurePathMatch方法
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        UrlPathHelper urlPathHelper = new UrlPathHelper();
        // 不移除后面的内容，这样可以使矩阵变量功能就可以生效
        urlPathHelper.setRemoveSemicolonContent(false);
        // 路径帮助器
        configurer.setUrlPathHelper(urlPathHelper);
    }


    // // 方法二:不需要实现WebMvcConfigurer接口,重新创建一个webMvcConfigurer
    // @Bean
    // public WebMvcConfigurer webMvcConfigurer() {
    //     return new WebMvcConfigurer() {
    //         @Override
    //         public void configurePathMatch(PathMatchConfigurer configurer) {
    //             UrlPathHelper urlPathHelper = new UrlPathHelper();
    //             // 不移除后面的内容，这样可以使矩阵变量功能就可以生效
    //             urlPathHelper.setRemoveSemicolonContent(false);
    //             // 路径帮助器
    //             configurer.setUrlPathHelper(urlPathHelper);
    //         }
    //     };
    // }
}
