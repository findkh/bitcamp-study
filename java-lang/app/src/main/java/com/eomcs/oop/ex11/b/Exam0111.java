//220211
package com.eomcs.oop.ex11.b;
// static nested class : 선언할 수 있는 멤버

class A2 {

  static class X {
    // top level class 처럼 스태틱 멤버 선언 가능
    static int v1;
    static void m1() {}
    static {}

    // top level class 처럼 인스턴스 멤버 선언 가능
    int v2;
    void m2() {}
    {}
  }

}

public class Exam0111 {
  public static void main(String[] args) {
    //일반적인 static 변수나 메서드를 사용하는 방법으로 사용하면 된다.
    A2.X.v1 = 100;
    A2.X.m1();

    // 레퍼런스 선언
    A2.X obj;

    // 인스턴스 생성
    obj = new A2.X();
  }
}
