package com.eomcs.oop.ex05.x7;

public abstract class Coffee {
  //라떼와 아메리카노의 공통점을 뽑아서 Coffee 클래스를 만든다.(일반화)
  char coffeeSize;
  boolean ice;

  public void Cup () {
    if(coffeeSize == 'L') {
      System.out.println("L 사이즈 컵을 준비한다.");
    } else if (coffeeSize == 'M') {
      System.out.println("M 사이즈 컵을 준비한다.");
    } else {
      System.out.println("S 사이즈 컵을 준비한다.");
    }
  }

  public void Cold() {
    if (ice == true) {
      System.out.println("얼음을 넣는다");
    } else
      System.out.println("얼음을 넣지 않는다");
  }

  public void SumIce(boolean ice) {
    this.ice = ice;
  }

  public void Espresso () {
    System.out.println("에스프레소를 넣는다");
  }

  //  서브 클래스마다 구현이 다르기 때문에 추상 메서드로 만든다.
  public abstract void makeCoffee();
}
