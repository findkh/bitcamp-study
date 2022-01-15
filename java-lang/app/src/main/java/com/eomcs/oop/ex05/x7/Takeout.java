package com.eomcs.oop.ex05.x7;

public class Takeout extends Option {

  //생성자
  public Takeout (Coffee coffee) {
    super(coffee);
  }

  @Override
  public void Cup() {
    System.out.println("테이크아웃 커피 준비");
    super.Cup();
  }

  @Override
  public void makeCoffee() {
    coffee.makeCoffee();
    System.out.println("손님 커피 받아가세요");
  }
}
