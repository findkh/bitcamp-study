package com.eomcs.mylist;

public class Todo {
  //필드 설정
  String title;
  boolean done;

  //프로퍼티 설정
  //getter, setter
  //변수의 값을 꺼내고 설정하는 메서드
  //메서드명이 get 또는 set으로 시작
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }
  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }

}
