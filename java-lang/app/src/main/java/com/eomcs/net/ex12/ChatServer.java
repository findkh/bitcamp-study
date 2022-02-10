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

        String nickname = in.readUTF();

        out.writeUTF(nickname + " 님 환영합니다");
        out.flush();

        while (true) {
          String message = in.readUTF(); //클라이언트에서 메세지를 받는다.
          if(message.equals("\\quit")) {
            out.writeUTF("<![QUIT[]]>"); //연결을 끊겠다는 특별한 메세지를 클라이언트에게 보낸다.
            //일반적으로 사용하지 않는 text를 사용한다.
            clientOutputStreams.remove(out); //메시지 출력 목록에서 연결이 종료된 클라이언트를 제거한다.
            out.flush();
            break; 
          } //종료가 아니라면 받은 메세지를 sendMessage로 보낸다
          sendMessage(String.format("[%s] %s",nickname, message));
        }

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 오류 - " + e.getMessage());
      }
    }
  }

  @SuppressWarnings("unchecked")
  public void sendMessage(String message) {
    ArrayList deleteStreams = new ArrayList(); //삭제 명단

    for (int i = 0; i < clientOutputStreams.size(); i++) {
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i);
      try {
        out.writeUTF(message);
      } catch (Exception e) {
        System.out.println("전송 오류: " + message);
        deleteStreams.add(out); //무효한 출력 스트림은 삭제 명단에 등록한다.
      }
    }

    // 삭제 명단에 등록된 출력 스트림을 반복문을 돌려서 제거 한다.
    for (Object deleteStream : deleteStreams) {
      clientOutputStreams.remove(deleteStream);
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
