package com.boot.config;

import com.boot.bean.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.Caret;

/**
 * ClassName BindTestConfig
 * Description TODO
 * Author 11931
 * Date 2022-10-02:0:01
 * Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(Car.class)
//1.开启car的配置绑定功能
//2.把这个 car这个组件自动注册到容器中
public class BindTestConfig {
}
