package com.eomcs.oop.ex05.x7;

public class CaffeLatte extends Coffee {
  static boolean MilkForm;

  @Override
  public void Cup() {
    this.cup();
  }

  @Override
  public void Cold() {
    this.Cold2(ice);
  }

  @Override
  public void Espresso() {
    this.Espresso2();
  }

  @Override
  public void makeCoffee() {
    this.makeCoffee2();
  }

  public void SumMilkForm() {
    if (MilkForm == true) {
      System.out.println("마지막에 우유 거품을 올린다");
    } else {
      System.out.println("마지막에 우유 거품을 올리지 않는다");
    }
  }

  public void makeCoffee2() {
    System.out.println("카페라떼 완성2");
  }

  //----------CoffeeShop1에서 사용하는 메서드들-----------
  public void cup() {
    System.out.println("매장용 컵을 준비한다.");
  }

  public void Cold2(boolean ice) {
    if (ice == true) {
      System.out.println("얼음을 넣는다2");
    } else
      System.out.println("얼음을 넣지 않는다2");
  }

  public void Espresso2 () {
    System.out.println("에스프레소를 넣는다2");
  }

  public void SteamedMilk() {
    System.out.println("따뜻한 우유를 넣는다");
  }
}
