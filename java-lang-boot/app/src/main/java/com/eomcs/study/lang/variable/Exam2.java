// 배열 : 같은 종류의 메모리를 여러 개 만드는 명령문

package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam2") //클래스 이름이 같은 경우 충돌 방지. 
//Spring Boot가 코드를 관리하기 윈한 코드에 대한 이름표

@RequestMapping("/lang/variable/exam2") // 웹브라우저가 실행시킬 경로명

public class Exam2 {
  //여러 개의 값을 받는 방법 : 배열 사용전
  //URL
  //http://localhost:8080/lang/variable/exam2/test1?name1=%ED%99%8D%EA%B8%B8%EB%8F%99&name2=%EC%9E%84%EA%BA%BD%EC%A0%95&name3=%EC%9C%A0%EA%B4%80%EC%88%9C&name4=%EC%95%88%EC%A4%91%EA%B7%BC&name5=%22%EC%9C%A4%EB%B4%89%EA%B8%B8%22&name6=%22%EA%B9%80%EA%B5%AC%22&name7=%22%ED%99%8D%EB%B2%94%EB%8F%84%22
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3, String name4, String name5, String name6, String name7) {
    return "=> " +  name1 + ", "+  name2 + ", " + name3 + ", " + name4 + ", " + name5 + ", " +name6 + ", " +name7;
  }

  //여러 개의 값을 받는 방법 : 배열 사용 후
  //->배열 메모리에 값을 넘길 때는 같은 파라미터 이름을 사용해야 한다.
  //URL
  //http://localhost:8080/lang/variable/exam2/test2?name=%EA%B9%80%EC%9B%90%EB%B4%89&name=%EC%9C%A0%EA%B4%80%EC%88%9C&name=%EA%B9%80%EA%B5%AC&name=%EC%86%90%EB%B3%91%ED%9D%AC&name=%EC%95%88%EC%A4%91%EA%B7%BC&name=%ED%99%8D%EB%B2%94%EB%8F%84&name=%22%EC%95%88%EC%B0%BD%ED%98%B8%22
  @GetMapping("/test2")
  public String test2(String[] name) {
    return "=> " +  name[0] + ", "+  name[1] + ", " + name[2] + ", " + name[3] + ", " + name[4] + ", " +name[5] + ", " +name[6];
  }

} 
