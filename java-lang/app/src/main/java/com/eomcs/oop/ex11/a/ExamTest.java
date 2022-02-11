//220211
package com.eomcs.oop.ex11.a;
// nested class : 종류

public class ExamTest {
  // 1) static nested class
  static class A {} 


  static int a; //static 변수
  static void m1() {} //static 메서드
  static {} //static 블록
  //static 멤버 = static nested class, static 변수, static 메서드, static 블록

  // 2) non-static class = inner class
  class B {} 

  int b; //인스턴스 변수
  void m2() {}; //인스턴스 메서드
  {} //인스턴스 블록
  //인스턴스 멤버 = inner class, 인스턴스 변수, 인스턴스 메서드, 인스턴스 블록

  public static void main(String[] args) {

    // 3) local class
    class C {}


    // 4) anonymous class 
    Object obj = new Object() {
      public void m1() {
        System.out.println("Hello!");
      }
    };
  }
}
