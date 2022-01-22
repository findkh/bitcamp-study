package com.eomcs.app1;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("> ");
      String input = keyScan.nextLine(); 

      if(input.equals("quit") || input.equals("exit")) {
        break;

      } else if(input.length() == 0) { //enter 공백제거
        continue;

      } else if(input.equals("help")) { //else if로 바꿔줌
        System.out.println("사용법: ");
        System.out.println("App [명령] [값1] [값2]");
        System.out.println("명령: ");
        System.out.println("add   [값1] [값2] 더하기 계산을 수행한다 ex)App add 100 200");
        System.out.println("minus [값1] [값2] 빼기 계산을 수행한다 ex)App minus 100 200");

      } else { //3. 명령어 처리하기
        String[] values = input.split(" "); //input을 공백으로 쪼갠후 String 배열에 담는다.
        if (values[0].equals("add")) {
          if(values.length != 3) { //입력값이 맞지 않으면 오류 메시지 출력
            System.out.println("명령어 입력형식이 옳지 않습니다.");
          } else {
            int num1 = Integer.parseInt(values[1]); 
            int num2 = Integer.parseInt(values[2]);
            System.out.printf("%d + %d = %d\n", num1, num2, (num1+num2));
          }
        } else if (values[0].equals("minus")) {
          if(values.length != 3) { //입력값이 맞지 않으면 오류 메시지 출력
            System.out.println("명령어 입력형식이 옳지 않습니다.");
          } else {
            int num1 = Integer.parseInt(values[1]); 
            int num2 = Integer.parseInt(values[2]);
            System.out.printf("%d - %d = %d\n", num1, num2, (num1-num2));
          }
        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      }
    }
    keyScan.close();
  }
}