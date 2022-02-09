package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ChatServer {

  int port;
  //클라이언트의 목록을 관리하기 위해 ArrayList를 만든다
  ArrayList clientOutputStreams = new ArrayList();

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)){
      System.out.println("서버 실행 중");

      while (true) {
        new RequestHandler(serverSocket.accept()).start();
        //1. serverSocket.accept() 실행
        //2. new RequestHandler(serverSocket.accept()) 실행
        //3. start() 실행
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류- " + e.getMessage());
    }
  }

  class RequestHandler extends Thread {
    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try (Socket socket2 = socket;
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        //서버에 보관한다
        clientOutputStreams.add(out);

        out.writeUTF("환영합니다");
        out.flush();

        while (true) {
          String message = in.readUTF(); //클라이언트에서 메세지를 받는다.
          if(message.equals("\\quit")) {
            out.writeUTF("Goodbye~");
            out.flush();
            break; 
          } //종료가 아니라면 받은 메세지를 sendMessage로 보낸다
          sendMessage(message);
        }

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 오류 - " + e.getMessage());
      }
    }
  }

  public void sendMessage(String message) {
    for (int i = 0; i < clientOutputStreams.size(); i++) {
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i);
      try {out.writeUTF(message);} catch (Exception e) {}
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
