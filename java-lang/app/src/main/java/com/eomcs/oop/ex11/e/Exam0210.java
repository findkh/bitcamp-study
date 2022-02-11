//220212
package com.eomcs.oop.ex11.e;
// anonymous class - 생성자

public class Exam0210 {

  interface A {
    void print();
  }
  /* 복습
  class X {
    public X() {

      System.out.println("Hello");
    }

    public X(int a) {

      System.out.println("Hello");
    }

    public X(String s) {

      System.out.println("Hello");
    }

    { //여러 생성자에 공통으로 들어갈 때 인스턴스 블록으로 설정해라
      //자바 컴파일러가 컴파일 할 때 인스턴스 블록을 클래스의 생성자 앞쪽으로 넣어 컴파일 한다.
      System.out.println("ABC2");
    }
  } */

  public static void main(final String[] args) {

    A obj = new A() {

      // 1) 익명 클래스는 생성자를 직접 정의할 수 없다.
      // - 그러나 컴파일러가 컴파일할 때 익명 클래스의 생성자를 만든다.
      //
      // 2) 대신 인스턴스 블록으로 생성자를 대신한다.
      // - 인스턴스 블록에 작성한 코드는
      //   결국 컴파일러가 자동 생성한 생성자에 들어간다.
      // - 그래서 인스턴스 블록에 작성한 코드가 실행될 것이다.
      {
        System.out.println("익명 클래스의 인스턴스 블록 실행!");
      }

      @Override
      public void print() {
        System.out.println("Hello!");
      }

    };
  }
}

// 수퍼 클래스 생성자 호출
// - 모든 클래스의 생성자는 항상 수퍼 클래스의 생성자를 먼저 호출한다.
// - 인터페이스를 구현한 익명 클래스는 java.lang.Object 클래스를 상속 받는다.
// - 따라서 익명 클래스의 생성자는 Object 클래스의 생성자를 먼저 호출한다.
//
