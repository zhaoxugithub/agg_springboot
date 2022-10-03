package com.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName ConfigBindTest
 * Description TODO
 * Author 11931
 * Date 2022-10-01:23:41
 * Version 1.0
 **/

@Component //将这个对象注入到容器里面，主要先把这个类注册到容器中才可以实现配置绑定
@ConfigurationProperties(prefix = "test")
public class ConfigBindTest {
    private String host;
    private String password;
    private Integer port;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "ConfigBindTest{" +
                "host='" + host + '\'' +
                ", password='" + password + '\'' +
                ", port=" + port +
                '}';
    }
}
