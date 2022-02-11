//220211
package com.eomcs.oop.ex11.b;
//static nested class : import static 사용 전

class D {
  static int v1;

  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }
}

public class Exam0410 {

  public static void main(String[] args) {
    // 같은 패키지 클래스
    D.v1 = 100;
    D.m1();
    D.X obj = new D.X();

    // 다른 패키지 클래스
    com.eomcs.oop.ex11.b.sub.M.v2 = 200;
    com.eomcs.oop.ex11.b.sub.M.m2();
    com.eomcs.oop.ex11.b.sub.M.Y obj2 = new com.eomcs.oop.ex11.b.sub.M.Y();
  }

}
