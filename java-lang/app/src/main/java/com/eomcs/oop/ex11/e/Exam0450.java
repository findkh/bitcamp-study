//220212
package com.eomcs.oop.ex11.e;

class My {
  static void m1() {
    System.out.println("하하하");
  }

  void m2() {
    System.out.println("쩝..");
  }
}

public class Exam0450 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static A create1() { //이 스태틱 메서드는 A인터페이스를 구현한 객체를 리턴해준다.
    class X implements A {
      @Override
      public void print() {
        System.out.println("Hello");
      }
    }
    return new X();
  }

  static A create2() {    
    return new A() {//A인터페이스를 구현한 익명 클래스를 정의한 후 객체를 생성한다. 생성자는 슈퍼클래스 생성자다.

      //인터페이스를 정의 했으니 인터페이스의 메서드를 구현해야 한다.
      @Override
      public void print() {
        System.out.println("Hello2");
      }
    }; 
  }

  //메서드 1개짜리 인터페이스인 경우 functional Interface라 한다.
  // 이럴 경우 람다도 표현 할 수 있다.
  static A create3() {
    return () -> System.out.println("Hello3");}

  static A create4() { //람다문법 -> 스태틱 메서드
    return My::m1;
  }

  static A create5() { //람다문법 -> 인스턴스 메서드
    return new My()::m2;
  }

  public static void main(String[] args) {    
    A obj1 = create1();
    obj1.print();

    A obj2 = create2();
    obj2.print();

    A obj3 = create3();
    obj3.print();

    A obj4 = create4();
    obj4.print();

    A obj5 = create5();
    obj5.print();
  }
}
