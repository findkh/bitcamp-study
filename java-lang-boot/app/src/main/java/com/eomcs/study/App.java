package com.eomcs.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.eomcs.study2", "com.eomcs.study"})
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
    //스프링 부트를 실행하는 문장
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello java-lang-boot";
  }
}