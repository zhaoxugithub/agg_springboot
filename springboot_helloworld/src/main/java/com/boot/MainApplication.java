package com.boot;

import com.boot.bean.Car;
import com.boot.bean.ConfigBindTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
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
// @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@Slf4j
public class MainApplication {
    public static void main(String[] args) {
        // 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 查看容器里面有哪些组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        /*        // 实例是单例的
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        // 结果是true
        System.out.println(tom2 == tom1);
        // 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单利对象
        // run.getBean(MyConfig.class)返回的实际上是被Spring cglib 增强的对象：com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$a27f01ed@28486680
        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println(myConfig);

        // 如果@Configuration(proxyBeanMethods = true) 代理对象调用方法。Springboot 总会检查这个组件是否在容器中存在，存在就会原来的
        // 保持组件单实例
        User user01 = myConfig.user01();
        User user02 = myConfig.user01();
        // 如果@Configuration(proxyBeanMethods = false) 返回的是false
        System.out.println(user02 == user01);

        // 如果@Configuration(proxyBeanMethods = true)
        User runBean = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        // 返回的是true
        System.out.println("runBean.getPet()" + (runBean.getPet() == tom));*/


        // 条件注入测试
        // 没有加上ConditionalOnBean
        boolean tom = run.containsBean("user01");
        // 返回的是true
        System.out.println(tom);
        // 加上给user01方法加上ConditionalOnBean(name = "tom"),并注释掉 @Bean("tom")
        boolean user01 = run.containsBean("user01");
        System.out.println(user01);


        ConfigBindTest bean = run.getBean(ConfigBindTest.class);
        System.out.println("bean.toString() = " + bean.toString());


        Car bean1 = run.getBean(Car.class);
        System.out.println("bean1 = " + bean1);


        MultipartAutoConfiguration bean3 = run.getBean(MultipartAutoConfiguration.class);
        MultipartProperties bean2 = run.getBean(MultipartProperties.class);
        System.out.println(bean2);
        System.out.println(bean3);

        //bean2和bean3都在容器中
    }
}
