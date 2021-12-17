package com.eomcs.lang.ex07;//211217

// # 메서드 : 개념 및 기본 문법 III
//
public class Exam0230 {

  // 3) 메서드 : 파라미터(X), 리턴값(O)
  //    => 메서드 블록을 실행한 후 값을 리턴하는 메서드.
  //       메서드 정의할 때 어떤 값을 리턴하는 지 그 타입을 적어야 한다.
  //       메서드에서도 종료하기 전에 반드시 그 타입의 값을 리턴해야 한다.
  //    => 리턴 타입은 반드시 한 개만 가능하다.
  //       만약 여러 개의 값을 리턴하고 싶다면, 배열에 담거나 객체에 담아 리턴하라!
  //    => "손들어. 돈내놔!"
  static String hello() {
    // 값을 리턴하는 문법
    // return 값;
    return "안녕하세요!"; // 리턴 명령을 실행하면 메서드 실행을 종료한다.

    // 메서드를 리턴한 후에 작업을 수행할 수 없다.
    //    int a; // 컴파일 오류!
    //    System.out.println("NO!"); // 컴파일 오류!
  }

  static int num() {
    return 10;
  }

  static String name() {
    return "하파";
  }

  static int age() {
    return 9;
  }

  public static void main(String[] args) {

    String n = name();
    int a1 = age();
    System.out.println(n + a1);
    System.out.println(name());
    System.out.println(age());

    // hello() 메서드를 실행하고, 그 리턴 값을 변수에 담는다.
    // => 리턴 값을 받을 변수를 준비한다.
    // => 변수에 리턴 값을 받는다.
    // => 리턴 값과 변수의 타입이 같아야 한다.
    String r = hello();
    System.out.println(r);

    // 메서드가 리턴한 값을 한 번만 사용할 경우 
    // 쓸데없이 로컬 임시 변수를 만들지 않는다.
    // 사용할 곳에 바로 메서드 호출 코드를 둔다.
    System.out.println(hello());

    // 메서드가 값을 리턴한다고 해서 반드시 그 값을 변수에 받아야 하는 것은 아니다.
    // 변수에 받을 지 여부는 호출하는 쪽의 마음이다.
    hello(); // 값을 받는 변수가 없으면 리턴 값은 버려진다.

    // 리턴 타입과 다른 타입의 변수로 값을 받으려 하면 컴파일 오류!
    //    int r2 = hello(); // 컴파일 오류!

    int a = num();
    System.out.println(a);
    System.out.println(num());
  }
}
