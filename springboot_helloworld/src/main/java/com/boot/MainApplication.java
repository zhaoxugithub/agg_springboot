package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 学习网站：https://www.yuque.com/atguigu/springboot/na3pfd
 * <p>
 * <p>
 * ClassName com.boot.MainApplication
 * Description TODO
 * Author 11931
 * Date 2022-09-30:0:01
 * Version 1.0
 **/
// 标记这是一个springboot的运行程序

// 注意这个启动类的存放位置
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {

        // 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 查看容器里面有哪些组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
