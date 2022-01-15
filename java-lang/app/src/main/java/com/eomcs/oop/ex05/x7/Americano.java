package com.eomcs.oop.ex05.x7;

public class Americano extends Coffee {

  @Override
  public void makeCoffee() {
    System.out.println("물을 넣는다");
    System.out.println("아메리카노 완성");
  }

  @Override
  public void SumIce(boolean ice) {
    super.SumIce(ice);
  }
}
