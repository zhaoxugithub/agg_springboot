package com.boot.config;

import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 告诉springboot这是一个配置类（配置文件）
public class MyConfig {

    @Bean  // 给容器中添加组件，以方法名作为组件的ID，返回类型就是组件类型。返回的值，就是组件在容器中实例
    public User user01() {
        return new User("zhangsan", 19);
    }

    @Bean
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }

}
