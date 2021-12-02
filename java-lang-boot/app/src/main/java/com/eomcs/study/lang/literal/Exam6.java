// 리터럴: 문자열 리터럴과 ﻿Escape charater
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam6")
public class Exam6 {

  @GetMapping("/test1")
  public String test1() {
    return "012ABC가각간똘똠똡똥"; 
  }

  @GetMapping("/test2")
  public String test2() {
    return "012\nABC\n가각간\n똘똠똡똥"; 
    //    제어코드 \n 엔터의 역할을 함
    //    LineFeed
  }

  @GetMapping("/test3")
  public String test3() {
    return "012\rABC\r가각간\r똘똠똡똥"; 
    //웹브라우저에서는 소용 없다.
    // \R
  }

  @GetMapping("/test4")
  public String test4() {
    return "012\tABC\t가각간\t똘똠똡똥"; 
  }

  @GetMapping("/test5")
  public String test5() {
    return "012\bABC\b가각간\b똘똠똡똥"; 
    //웹브라우저에서는 소용 없다.
  }

  @GetMapping("/test6")
  public String test6() {
    return "012\\bABC\\b가각간\\b똘똠똡똥"; 
  }
}







