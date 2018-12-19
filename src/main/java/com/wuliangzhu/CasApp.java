package com.wuliangzhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot2 需要 spring5 兼容否侧会出错
 * spring logging 的配置也会做出调整
 * 也需要druid 的 1.10 否则也会出错
 */
@SpringBootApplication
public class CasApp{
    public static void main(String[] args) {
        SpringApplication.run(CasApp.class, args);
    }
}
