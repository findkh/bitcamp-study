//220211
package com.eomcs.oop.ex11.a;
// nested class : 로컬 클래스의 접근 제어

public class Exam0311 {

  static void m1() {
    // 로컬 변수처럼 로컬 클래스에는 접근 제어 modifier 를 붙일 수 없다.
    //    private class A1 {} // 컴파일 오류!
    //    protected class A2 {} // 컴파일 오류!
    //    public class A3 {} // 컴파일 오류!
    // 로컬 클래스에는 public을 붙일 수 없다. 
    // 내부 메서드 안에서만 쓰이기 때문에 로컬 클래스로 만들었는데, public으로 공개할 수 없다.

    class A4 {} // OK!
  }

  void m2() {
    // 로컬 변수처럼 로컬 클래스에는 접근 제어 modifier 를 붙일 수 없다.
    //    private class B1 {} // 컴파일 오류!
    //    protected class B2 {} // 컴파일 오류!
    //    public class B3 {} // 컴파일 오류!

    class B4 {} // OK!
  }
}