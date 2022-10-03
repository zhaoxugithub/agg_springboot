package com.boot.config;

import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
  1.配置了里面的@bean标注在方法上给容器注册组件（对象），默认是单利的

  2.配置类本身也是也容器里面的对象
  3.proxyBeanMethods:代理bean的方法
       Full(ProxyBeanMethods = true)：保证每个@bean方法返回的对象都是单实例的
       Lite(ProxyBeanMethods = false):保证每个对象返回的都是新创建的

  4.import({User.class,DBHelper.class})
       给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 5.@ImportResource("classpath:bean.xml")导入spring的配置文件
 */
@Configuration(proxyBeanMethods = true)  // 告诉springboot这是一个配置类（配置文件）
// @ConditionalOnBean(name = "tom") //表示的是如果有tom这个组件被注入了，这个类中的其他对象才会被注入
public class MyConfig {
    @Bean  // 给容器中添加组件，以方法名作为组件的ID，返回类型就是组件类型。返回的值，就是组件在容器中实例
    @ConditionalOnBean(name = "tom") //语义是：如果tom这个组件(对象)被注入了，user01这个组件才会被注入
    public User user01() {
        User zhangsan = new User("zhangsan", 19);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }
    // @Bean("tom") // 自定义组件id名
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
