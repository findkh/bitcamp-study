// 리터럴: 문자리터럴과 값의 범위
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam5")
public class Exam5 {

  @GetMapping("/test1")
  public String test1() {
    return "문자1: "+'A'+'가'; //문자1: A가
    //양쪽에 싱글쿼테이션으로 적는다
    //문자열 더하기 값은 그 값들이 문자열로 바뀐다음 하나의 문자열로 합쳐져서 웹 브라우저에 나옴 
  }

  @GetMapping("/test2")
  public String test2() {
    return "문자2: "+'\u0041'+'\uac00'; //문자2: A가
    //문자에 대한 유니코드 값을 지정해도 된다.
    //싱글쿼테이션으로 유니코드를 표현할 때는 \ u를 적고 유니코드 값을 넣어줘야 한다
  }

  @GetMapping("/test3")
  public String test3() {
    return "문자3: " + (char)0x41 + " , " + (char)0xac00; //문자3: A , 가
    //문자 코드를 정수 값으로 지정한다. 대신 문자 코드임을 표시해야 한다.-> char()
    //type casting이다.
  }

  @GetMapping("/test4")
  public String test4() {
    return "문자4: " + (char)65 + " , " + (char)44032; //문자4: A , 가
    //문자 코드를 정수 값은 그냥 정수값이다. 대신 문자 코드임을 표시해야 한다.-> char()
    //
  }

  @GetMapping("/test5")
  public String test5() {
    return "문자5: " + 0x41 + " , "+ 0xac00 + "    문자6: " + 0b10001 +" , "+  0xac00 ; 
    //16진수로 정수 값을 표현 했지만 문자열과 정수값이 합쳐질 때는 
    //10진수로 바꾸어서 하나의 문자열이 만들어져서 웹 브라우저로 리턴한다.
    //자바는 기본적으로 10진수로 나타낸다.
    //내가 어떤 진수를 적었든 10진수 형태로 문자로 바뀌고 합쳐져셔 문자열로 나타난다.
  }

  @GetMapping("/test6")
  public String test6() {
    return "문자2: " + '\u4eba' + '\u00a9' + '\u03c0' + '\u03a3';
    //키보드에서 입력 불가능한 특수 문자를 가리킬 때 주로 유니코드를 사용한다.
  }
}