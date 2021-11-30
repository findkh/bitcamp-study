// 리터럴 : 자바에서 값을 표현하는 것

package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam1")
public class Exam1 {

  @GetMapping("/test1")
  public String test1() {
    //문자열을 표현하는 방법
    return "홍길동";
  }

  @GetMapping("/test2")
  public char test2() {
    //문자를 표현하는 방법
    return '홍';
  }

  @GetMapping("/test3")
  public int test3() {
    //숫자를 표현하는 방법
    return 100;
  }

  @GetMapping("/test4")
  public double test4() {
    //부동소숫점를 표현하는 방법
    return 3.14;
  }

  @GetMapping("/test5")
  public boolean test5() {
    //논리를 표현하는 방법
    return false;
  }

  @GetMapping("/test6")
  public Object test6() {
    //주소가 지정되지 않았음을 표현하는 방법
    return null;
  }

} 
