//220211
package com.eomcs.oop.ex11.b;
// static nested class : 클래스 정의와 인스턴스 생성

class A {
  static int a;
  static void m() {}

  static class X {}
}

public class Exam0110 {

  public static void main(String[] args) {
    A.a = 100;
    A.m();    // 일반적인 static 변수나 메서드를 사용하는 방법으로 사용하면 된다.

    // 레퍼런스 선언
    A.X obj;

    // 인스턴스 생성
    obj = new A.X();
  }
}

//중첩 클래스는 사용 범위를 제한하기 위해 사용하는데
//왜 다른 클래스에서 중첩 클래스를 호출하는가?
//(A클래스에서 사용하려고 X를 중첩클래스로 만들었는데 왜 호출하는가?)
//->중첩 클래스를 사용하는 주된 이유는 사용 범위를 제한하기 위해 만든 것은 맞다.
//  작은 클래스를 패키지로 관리하지 않고 하나의 클래스에 담아서 소스 코드를 관리하기 편하기 위해서 사용한다.
