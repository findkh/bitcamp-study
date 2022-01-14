package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {
  int auto;
  boolean oepnedSunroof;

  @Override
  public void run() {
    System.out.println("세단 달린다");
  }

  public void openSunroof() {
    if (oepnedSunroof == true) {
      System.out.println("썬루프 오픈");
    } else {
      System.out.println("썬루프 닫음");
    }
  }
}
