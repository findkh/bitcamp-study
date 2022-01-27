package com.eomcs.app1;

public class CommandHandler {
  // 메서드를 클래스로 분리해냄
  // 향후 확장성은 위해 지금 인스턴스 필드를 사용하지 않아도
  // static을 제거하고 인스턴스 메서드로 만든다

  void doHelp() {
    System.out.println("사용법: ");
    System.out.println("App [명령] [값1] [값2]");
    System.out.println("명령: ");
    System.out.println("add   [값1] [값2] 더하기 계산을 수행한다 ex)App add 100 200");
    System.out.println("minus [값1] [값2] 빼기 계산을 수행한다 ex)App minus 100 200");
  }

  void doAdd(Command command) {
    if(command.getParamSize() != 2) { //입력값이 맞지 않으면 오류 메시지 출력
      System.out.println("명령어 입력형식이 올바르지 않습니다.");
      System.out.println("형식 : add 값1 값2");
      System.out.println("ex) add 100 200");
    } else {
      int num1 = command.getInt(0);
      int num2 = command.getInt(1);
      System.out.printf("%d + %d = %d\n", num1, num2, (num1+num2));
    }
  }

  void doMinus(Command command) {
    if(command.getParamSize() != 2) { //입력값이 맞지 않으면 오류 메시지 출력
      System.out.println("명령어 입력형식이 올바르지 않습니다.");
      System.out.println("형식 : minus 값1 값2");
      System.out.println("ex) minus 100 200");
    } else {
      int num1 = command.getInt(0);
      int num2 = command.getInt(1);
      System.out.printf("%d - %d = %d\n", num1, num2, (num1-num2));
    }
  }
}
