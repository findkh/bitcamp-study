package com.eomcs.oop.ex05.x7;

public class VanillaLatte extends Coffee {
  boolean syrup;

  @Override
  public void makeCoffee() {
    System.out.println("따뜻한 우유를 넣는다");
    if (syrup == true) {
      System.out.println("바닐라 시럽을 넣는다");
      System.out.println("바닐라 라떼 완성");
    } else {
      System.out.println("시럽을 넣지 않으면 그냥 라떼");
    }
  }

  @Override
  public void SumIce(boolean ice) {
    super.SumIce(ice);
  }

  public void SumSyrup(boolean add) {
    this.syrup = add;
  }
}
