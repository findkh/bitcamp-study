//220215
package com.eomcs.oop.ex12;
// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스


public class Exam0510x {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {

    //1. 로컬클래스
    class Mycal implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }

    Calculator c1 = new Mycal();

    System.out.println(c1.compute(200, 17));

    //2. 익명 클래스로 만들기
    Calculator c2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };

    System.out.println(c2.compute(200, 17));

    //3. 람다 문법 적용
    Calculator c3 = (x, y) -> MyCalculator.plus(x, y);

    System.out.println(c3.compute(200, 17));

    //4. 메서드 레퍼런스
    Calculator c4 = MyCalculator::plus;
    System.out.println(c4.compute(200, 17));


    /*연습
   System.out.println(c1.compute(200, 17));

   System.out.println(c2.compute(200, 17));

   System.out.println(c3.compute(200, 17));

   System.out.println(c4.compute(200, 17));
     */

    /*
    //1. 로컬 클래스로 만들기
    class MyCal implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }
    //인스턴스 생성
    Calculator c1 = new MyCal();
    System.out.println(c1.compute(200, 17));

    //2. 익명 클래스로 만들기
    Calculator c2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };
    System.out.println(c2.compute(200, 17));

    //3. 람다 문법으로 만들기
    Calculator c3 = (x, y) -> MyCalculator.plus(x, y);
    System.out.println(c3.compute(200, 17));

    //4. 메서드 레퍼런스
    Calculator c4 = MyCalculator::plus;
    System.out.println(c4.compute(200, 17));
     */
  }
}


