package com.wuliangzhu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/back")
    public String back() {
        return "i am back";
    }

    @GetMapping("/callback")
    public String callback(){
        return "callback";
    }
}
