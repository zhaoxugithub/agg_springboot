package com.example.springboot_web.controller;

import org.springframework.web.bind.annotation.*;

/**
 * ClassName TestController
 * Description TODO
 * Author 11931
 * Date 2022-10-04:10:57
 * Version 1.0
 **/
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "aaaaa";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {

        return "GET-张三";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST-张三";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {

        return "PUT-张三";
    }

    @DeleteMapping("/user")
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-张三";
    }
    // 扩展点：如何把 _method 这个名字换成我们自己喜欢的
    //方法是：自定义配置
}
