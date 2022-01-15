package com.eomcs.oop.ex05.x7;

public class Delivery extends Option {
  //생성자
  public Delivery (Coffee coffee) {
    super(coffee);
  }

  @Override
  public void Cup() {
    System.out.println("배달 준비");
    super.Cup();
  }

  @Override
  public void makeCoffee() {
    coffee.makeCoffee();
    System.out.println("배달 시작");
  }
}
