package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName controller
 * Description TODO
 * Author 11931
 * Date 2022-09-29:23:54
 * Version 1.0
 **/
@RestController
//等价于
//@Controller
// @ResponseBody
public class HelloController {
    @RequestMapping("hello")
    public String handle() {
        return "hello,world springboot2";
    }
}
