package com.eomcs.net.ex11.test;
//stateful 방식

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient2 {
  public static void main(String[] args) {
    try(
        Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      while (true) {
        String str = in.nextLine();
        if (str.length() == 0) {
          break;
        }
        System.out.println(str);
      }

      while (true) {
        System.out.println("계산식> ");
        String input = keyScan.nextLine();

        if (!input.equals("quit") && input.split(" ").length != 3) {
          System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
          continue;
        }

        out.println(input);
        out.flush();

        String str = in.nextLine();
        System.out.println(str);

        if(input.equals("quit")) {
          break;
        }
      }

    }catch (Exception e) {
      System.out.println("서버 연결 오류");
    }
  }
}