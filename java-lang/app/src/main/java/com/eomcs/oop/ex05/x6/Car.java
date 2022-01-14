package com.eomcs.oop.ex05.x6;

public abstract class Car {
  //Sedan과 Truck의 공통점을 뽑아서 Car 클래스를 만든다.(일반화)
  int cc;
  boolean valve;

  public void start() {
    System.out.println("시동을 켠다");
  }

  public void stop() {
    System.out.println("시동 끈다");
  }

  //서브 클래스마다 구현이 다르기 때문에 추상 메서드로 만든다.
  public abstract void run();
}
