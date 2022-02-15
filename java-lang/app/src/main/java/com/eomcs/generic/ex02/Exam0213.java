//220215
package com.eomcs.generic.ex02;
// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 

import java.util.ArrayList;

public class Exam0213 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */

  public static void main(String[] args) {
    // 레퍼런스와 레퍼런스에 제네릭을 지정했을 때 그 레퍼런스의 객체를 담는곳의 제네릭타입은 무엇이 가능한지.
    // 수퍼클래스도 자식 클래스도 안된다.

    ArrayList<A> list1;

    //    list1 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //    list1 = new ArrayList<Object>(); // 컴파일 오류!
    list1 = new ArrayList<A>();
    list1 = new ArrayList<>(); //생략하면 레퍼런스와 같은 제네릭 타입이 된다.
    //    list1 = new ArrayList<B1>(); // 컴파일 오류!
    //    list1 = new ArrayList<B2>(); // 컴파일 오류!
    //    list1 = new ArrayList<C>(); // 컴파일 오류!

    list1.add(new B2());

    ArrayList<B2> list2;

    //    list2 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //    list2 = new ArrayList<Object>(); // 컴파일 오류!
    list2 = new ArrayList<B2>();
    list2 = new ArrayList<>(); //B2를 생략한 문법이다.
    //    list2 = new ArrayList<A>(); // 컴파일 오류!
    //    list2 = new ArrayList<B1>(); // 컴파일 오류!
    //    list2 = new ArrayList<C>(); // 컴파일 오류!
  }
}








