package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// 역할 : 소켓에 연결된 클라이언트 요청을 처리한다.
public class RequestProcessor1 {
  Socket socket;

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public void service() throws Exception {
    try (Socket socket = this.socket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());) {

      //메시지 출력 메서드 만들기
      sendGreeting(out);

      // 클라이언트가 보낸 요청을 받아 그대로 되돌려 준다.
      while(true) {
        String request = in.readLine();

        //종료 요청 처리
        if (request.equalsIgnoreCase("quit") || request.equalsIgnoreCase("exit")) {
          sendMessage(out, "end!!!");
          break;
        }

        String message = compute(request);
        sendMessage(out, message); //클라이언트에게 응답한다.
      }
    }
  }

  private String compute(String request) {
    try {
      String[] values = request.split(" ");

      int a = Integer.parseInt(values[0]);
      String op = values[1];
      int b = Integer.parseInt(values[2]);
      int result = 0;

      switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        case "%": result = a % b; break;
        default:
          return String.format("%s 연산자를 지원하지 않습니다.", op);
      }
      return String.format("결과는 %d %s %d = %d 입니다.", a, op, b, result);

    } catch (Exception e) {
      return String.format("계산 중 오류 발생 - %s", e.getMessage());
      //ex) by zero
    }
  }

  private void sendMessage(PrintStream out, String message) {
    out.println(message);
    out.println();
    out.flush();
  }

  private void sendGreeting(PrintStream out) throws Exception {
    out.println("[계산기 서비스]");
    out.println("계산기 서버에 오신 걸 환영합니다!");
    out.println("계산식을 입력하세요!");
    out.println("ex) 23 + 7");
    out.println(); //응답의 끝을 표시하는 빈 줄을 보낸다.
    out.flush();
  }
}


