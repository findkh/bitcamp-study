package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient1 {
  public static void main(String[] args) {

    try(
        Scanner sc = new Scanner(System.in); //사용자로부터 계산식 입력 받을 sc
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      //응답을 읽는 메서드 호출
      receiveResponse(in);

      while(true) {
        String input = prompt(sc); //입력값 유효성 감사한 후 input 변수에 담는다.
        if (input == null) {
          continue;
        }
        sendRequest(out, input); //서버에 요청을 보내기
        receiveResponse(in); //서버의 실행 결과 받기

        //프로그램 종료 명령 처리
        if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
          break;
        }
      }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  static String prompt(Scanner sc) {
    //입력값 유효성 검사
    System.out.print("계산식 > ");
    String input = sc.nextLine();

    if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
      return input;
    }

    if (input.split(" ").length != 3) {
      System.out.println("입력 값이 올바르지 않습니다. ex)3 + 5");
      return null;
    }
    return input;
  }

  static void sendRequest(PrintStream out, String message) throws Exception {
    out.println(message);
    out.flush();
  }

  static void receiveResponse(BufferedReader in) throws Exception {
    //응답의 종료 조건 설정 : 빈 줄을 받을 때까지 응답을 읽어 출력한다.
    while (true) {
      String input = in.readLine();
      if (input.length() == 0) { //빈 줄을 읽었다면 읽기를 끝낸다.
        break;
      }
      System.out.println(input);
    }
  }
}
