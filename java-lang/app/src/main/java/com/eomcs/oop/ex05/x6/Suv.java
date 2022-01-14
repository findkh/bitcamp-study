package com.eomcs.oop.ex05.x6;

public class Suv extends Car {
  boolean actvie4wd;

  @Override
  public void run() {
    if (actvie4wd == true) {
      System.out.println("4wd 달린다");
    } else {
      System.out.println("그냥 달린다");
    }
  }

  public void active4wd(boolean enable) {
    this.actvie4wd = enable;
  }
}
