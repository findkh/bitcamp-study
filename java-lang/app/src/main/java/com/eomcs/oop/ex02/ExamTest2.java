package com.eomcs.oop.ex02;

/*
1) 관련 메서드를 클래스로 묶는다
2) 메서드에서 계산한 결과를 클래스 변수에 저장한다
3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.
4) 인스턴스 메서드로 바꿔서 인스턴스 주소를 this 변수에 받는다.
5) calculator 클래스를 별도 소스 파일로 분리한다
6) calculator를 별도의 패키지로 분류한다.
 */
import com.eomcs.oop.ex02.util.Calculator3;

public class ExamTest2 {


  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();

    c1.plus(2);
    c2.plus(3);

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);
    c2.plus(7);

    c1.multiple(7);
    c2.divide(4);

    c1.divide(3);
    c2.minus(5);

    System.out.printf("c1.result = %d\n", c1.getResult());
    System.out.printf("c2 result = %d\n", c2.getResult());
  }
}

