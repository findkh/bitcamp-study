//220207
package com.eomcs.exception.ex91;
// 예외 처리 - 예외 발생과 예외 처리

public class Exam0210 {

  public static void main(String[] args) {

    // 예외 발생과 처리 과정
    // - 명령 실행 중에 예외가 발생하면,
    //   예외 상황을 객체에 담아 전달한다.
    // - 예외 처리 코드가 있다면,
    //   해당 코드를 실행한다.
    // - 예외 처리 코드가 없다면,
    //   예외 처리 코드를 만날 때까지
    //   메서드의 호출자를 따라 올라가면서 예외를 전달한다.
    //   main() 메서드를 호출한 곳까지 도달하면
    //   예외 정보를 출력한 후 즉시 실행을 멈춘다.
    //
    // 예외 객체
    // - 예외 정보를 담고 있다.
    // - java.lang.Throwable 타입의 객체다.
    //
    // 예외 처리 문법
    //      try {
    //          명령문;
    //          ...
    //      } catch (Throwable 예외객체를_받을_파라미터) {
    //          예외처리 명령문;
    //          ...
    //      }
    //

    try {
      // 예외가 발생할 수 있는 코드를 이 블록에 둔다.
      int result = 100 / 0;
      System.out.printf("계산 결과 = %d\n", result);

    } catch (Throwable e) {
      // 예외가 발생하면 이 블록이 실행된다.
      // 파라미터로 예외 정보가 담겨있는 객체를 받는다.
      System.out.println("나누기 연산 중 오류 발생!");
    }

    // 예외 처리 문법이 필요한 이유?
    // - 예외가 발생하더라도
    //   즉시 프로그램을 종료하지 않고 적절한 조치를 취한 후
    //   프로그램을 계속 실행할 수 있게 해주기 때문이다.
    //
  }
}














