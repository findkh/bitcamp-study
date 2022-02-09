package com.eomcs.net.ex12.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Client extends Frame {
  private static final long serialVersionUID = 1L;

  public Client() {
    super("계산기");
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(400, 300);

    Panel topPanel = new Panel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    TextField addressTf = new TextField(30);
    topPanel.add(addressTf);

    TextField portTt = new TextField(4);
    topPanel.add(portTt);

    Button connectBtn = new Button("연결");
    topPanel.add(connectBtn);

    add(topPanel, BorderLayout.NORTH);

    TextArea messageListTa = new TextArea();
    add(messageListTa, BorderLayout.CENTER);

    Panel bottomPanel = new Panel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    TextField messageTf = new TextField(40);
    bottomPanel.add(messageTf);

    Button sendBtn = new Button("보내기");
    bottomPanel.add(sendBtn);

    add(bottomPanel, BorderLayout.SOUTH);

    setVisible(true);
  }

  public static void main(String[] args) {
    new Client(); //new 명령어로 인스턴스가 만들어지고 ()에 의해 생성자가 만들어진다
  }
}
