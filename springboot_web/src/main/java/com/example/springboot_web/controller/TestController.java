package com.example.springboot_web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName TestController
 * Description TODO
 * Author 11931
 * Date 2022-10-04:10:57
 * Version 1.0
 **/
@RestController
public class  TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "aaaaa";
    }


}
