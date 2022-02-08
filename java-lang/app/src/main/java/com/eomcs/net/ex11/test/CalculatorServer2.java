package com.eomcs.net.ex11.test;
//stateful 방식
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer2 {

  String logo;

  //로고 만드는 것을 생성자로 빼서 파일 읽는 것을 한 번만 하게 만듦
  public CalculatorServer2() {
    StringBuilder logoStr = new StringBuilder();

    try (BufferedReader welcomeIn = new BufferedReader(new FileReader("welcome.txt"))) {

      while(true) {
        String str = welcomeIn.readLine();
        if (str == null) {
          break;
        }
        logoStr.append(str + "\n");
      }
    } catch (Exception e) {
      if (logoStr.length() > 0) {
        logoStr.setLength(0);
      }
      logoStr.append("환영합니다!\n");
    }

    logo = logoStr.toString();
  }

  public void launch(int port) {
    try (ServerSocket serverSocekt = new ServerSocket(port)) {
      System.out.println("서버 실행 중...");

      while(true) {
        //Socket socket = serverSocekt.accept(); //클라이언트와 연결된 Socket
        //RequestHandler requestHandler = new RequestHandler(socket, logo);
        //위에 2줄 줄여쓰기

        //RequestHandler requestHandler = new RequestHandler(serverSocekt.accept(), logo);
        //requestHandler.start();
        //위에 2줄 또 줄여쓰기
        new RequestHandler(serverSocekt.accept()).start();
      }

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생");
    }
  }

  public static void main(String[] args) {
    //CalculatorServer2 server = new Server();
    //server.launch(8888);
    //줄여서 쓰기
    new CalculatorServer2().launch(8888);
  }

  class RequestHandler extends Thread {
    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try(
          Socket socket2 = socket; //close()를 자동 호출하기 위해 임시 변수 만듦
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        out.print(logo);

        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7");
        out.println();

        while (true) {
          String str = in.nextLine();
          if (str.equals("quit")) {
            out.println("Goodbye~~");
            out.flush();
            break;
          }

          try {
            String[] values = str.split(" ");
            int a = Integer.parseInt(values[0]);
            String op = values[1];
            int b = Integer.parseInt(values[2]);

            switch (op) {
              case "+": out.printf("%d %s %d = %d\n", a, op, b, a + b); break;
              case "-": out.printf("%d %s %d = %d\n", a, op, b, a - b); break;
              case "*": out.printf("%d %s %d = %d\n", a, op, b, a * b); break;
              case "/": out.printf("%d %s %d = %d\n", a, op, b, a / b);break;
              case "%": out.printf("%d %s %d = %d\n", a, op, b, a % b);break;
              default:  out.printf("%d %s %d = %s\n", a, op, b, "지원하지 않는 연산자입니다");
            }
            out.flush();
          } catch (Exception e) {
            out.println("계산 중 오류 발생 -" + e.getMessage());
          }
        }

      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }
}


