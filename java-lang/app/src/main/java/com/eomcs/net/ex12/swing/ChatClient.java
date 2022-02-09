package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame {
  private static final long serialVersionUID = 1L;

  Socket socket; 
  DataInputStream in;
  DataOutputStream out;

  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(4);
  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(35);

  public ChatClient() {
    super("채팅");
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex){}
        System.exit(0);
      }
    });
    setSize(500, 400);

    Container contentPane = this.getContentPane();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    topPanel.add(addressTf);
    topPanel.add(portTf);
    JButton connectBtn = new JButton("연결");

    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);
    contentPane.add(topPanel, BorderLayout.NORTH);

    JScrollPane scrollPane = new JScrollPane(messageListTa);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.add(messageTf);
    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);
    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage); //enter치면 전송되게 이벤트 리스너 등록

    setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    new ChatClient(); 
  }

  public void connectChatServer(ActionEvent e) {
    System.out.println("서버에 연결하기");
    System.out.println(addressTf.getText());
    System.out.println(portTf.getText());

    try {
      socket = new Socket(
          addressTf.getText(), //주소
          Integer.parseInt(portTf.getText())); //포트번호

      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      new MessageReceiver(in).start(); //스레드 가동

    } catch(Exception ex) {
      JOptionPane.showMessageDialog(this, "서버 연결 오류", "통신 오류", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void sendMessage(ActionEvent e) {
    System.out.println("메시지 보내기");

    if (messageTf.getText().length() == 0) { 
      return;
    }

    try {
      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText(""); //메세지 입력창 초기화

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "메세지 전송 오류", "통신 오류", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread {
    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }
    @Override
    public void run() { //서버에 연결되는 순간 가동된다.
      while (true) { //무한루프를 돌면서 서버가 보낸 메세지가 있는지 기다린다.
        try {
          String message = in.readUTF();
          messageListTa.append(message + "\n"); //서버에서 메세지를 보내면 받아서 화면에 붙인다.

        } catch (Exception e) {}
      }
    }
  }
}
