package com.eomcs.net.ex11.test;

import java.net.ServerSocket;

public class CalculatorServer1 {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("내 서버 실행 중");

      //클라이언트의 요청을 처리하는 메서드를 별도의 클래스(RequestProcessor)로 분리함
      //new RequestProcessor(serverSocket.accept()).service();
      //풀어쓰기
      //Socket socket = serverSocket.accept();
      //RequestProcessor requestProcessor = new RequestProcessor(socket);
      //requestProcessor.service();

      RequestProcessor1 requestProcessor = new RequestProcessor1();

      //반복문 사용해서 여러 개의 클라이언트 접속을 처리한다
      while (true) {
        requestProcessor.setSocket(serverSocket.accept());
        requestProcessor.service();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}