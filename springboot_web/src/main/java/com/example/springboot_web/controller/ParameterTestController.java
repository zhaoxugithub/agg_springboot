package com.example.springboot_web.controller;

import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName ParameterTestController
 * Description TODO
 * Author 11931
 * Date 2022-10-06:2:28
 * Version 1.0
 **/
@Slf4j
@RestController
public class ParameterTestController {

    /*
        @PathVariable:获取路径变量上的值，比如/car/{id}/owner/{username},获取id,username
                使用map可以获取id和username的值
                 {
                    "pv": {
                    "id": "1",
                    "username": "zx"
                    },
                    "name": "zx",
                    "id": 1
                    }



        @RequestHeader
        @ModelAttribute
        @RequestParam
        @MatrixVariable
        @CookieValue
        @RequestBody
     */
    //  car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params
                                      // @CookieValue("_ga") String _ga,
                                      // @CookieValue("_ga") Cookie cookie

    ) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        // map.put("_ga", _ga);
        // map.put("cookie", cookie);
        log.info("map={}", map);
        // log.info("cookie = {}", cookie);
        return map;
    }


    /*
        RequestBody:适用于post请求

     */
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        log.info("content={}", content);
        return map;
    }


    // 1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    // 2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    // 3、矩阵变量必须有url路径变量PathVariable / pathVar才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
