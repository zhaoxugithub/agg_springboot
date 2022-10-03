package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName Car
 * Description TODO
 * Author 11931
 * Date 2022-10-02:0:01
 * Version 1.0
 **/
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "car")
public class Car {
    private String brand;
    private Integer price;
}
