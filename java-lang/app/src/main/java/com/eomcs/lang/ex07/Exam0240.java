package com.eomcs.lang.ex07;//211217

//# 메서드 : 개념 및 기본 문법 IV
//
public class Exam0240 {

  // 4) 메서드 : 리턴값(O), 파라미터(O)
  // => "이 돈 갖고 과자좀 사와!"
  static String hello(String name, int age) {
    String retVal = String.format("%d살 %s님을 환영합니다!", age, name);
    //string이라는 클래스에 format이라는 메서드가 있다
    //받은 파라미터 값을 %d %s 자리에 넣고 최종적으로 문자열을 만든후 그 문자열을 return한다
    return retVal;
  }

  static String hi(String name, int age) {
    String hello = String.format("%d살 %s님 병원오세요", age, name);
    return hello;
  }

  public static void main(String[] args) {

    String h = hi("하파", 9);
    System.out.println(h);

    // hello() 메서드를 실행하고, 그 리턴 값을 변수에 담는다.
    String r = hello("홍길동", 20);
    System.out.println(r);

    // 앞의 예제와 마찬가지로 리턴 값을 한 번만 사용한다면,
    // 사용할 곳에 메서드 호출 코드를 둬라!
    // => 리팩토링 기법 중에서 "replace temp with query" 라 부른다.
    System.out.println(hello("홍길동", 20));

    // 리턴 값을 안 받아도 된다.
    hello("임꺽정", 30); // 리턴 값은 버려진다.
  }
}
