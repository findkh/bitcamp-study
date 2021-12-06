// 변수 : 스트링부트의 자동 형변환

package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam3") //클래스 이름이 같은 경우 충돌 방지.
@RequestMapping("/lang/variable/exam3")
public class Exam3 {

  //  스프링 부트는 클라이언트가 보낸 값을 파라미터 타입에 맞춰 자동 형변환을 수행한다.
  //-> 웹 브라우저가 보내는 값은 무조건 "문자열"이다.

  //  테스트 URL
  //=>http://localhost:8080/lang/variable/exam3/test1?value=100
  //1) "100" --> byte
  @GetMapping("/test1")
  public String test1(byte value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //  테스트 URL
  //http://localhost:8080/lang/variable/exam3/test2?value=32767
  //2) "32767" --> short
  @GetMapping("/test2")
  public String test2(short value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //  테스트 URL
  //http://localhost:8080/lang/variable/exam3/test3?value=456789
  //3) "456789" --> int
  @GetMapping("/test3")
  public String test3(int value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //  테스트 URL
  //http://localhost:8080/lang/variable/exam3/test4?value=2244445555
  //4) "2244445555" --> long
  @GetMapping("/test4")
  public String test4(long value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //테스트 URL
  //http://localhost:8080/lang/variable/exam3/test5?value=3.14
  //5) "3.14" --> float
  @GetMapping("/test5")
  public String test5(float value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }
  //http://localhost:8080/lang/variable/exam3/test6?value=3456.7898
  //1) "3456.7898" --> double
  @GetMapping("/test6")
  public String test6(double value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //http://localhost:8080/lang/variable/exam3/test7?value=true
  //true,1,True -> true
  //false,0,False -> false
  //7) "true" ==> boolean
  @GetMapping("/test7")
  public String test7(boolean value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //http://localhost:8080/lang/variable/exam3/test8?value=%EA%B0%80
  //8) "가" --> char
  @GetMapping("/test8")
  public String test8(char value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }

  //http://localhost:8080/lang/variable/exam3/test9?value=2021-12-06
  //9) "2021-12-06" --> Date
  @GetMapping("/test9")
  public String test9(java.sql.Date value) {
    return "==> " + value;
    //String 변수에 저장할 데이터 타입 name은 변수명이다
  }




} 
