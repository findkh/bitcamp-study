package com.eomcs.oop.ex05.x6;

public class SnowChain extends Option {

  //생성자
  public SnowChain (Car car) {
    super(car);
  }

  @Override
  public void run() {
    System.out.println("체인 장착");
    car.run();
  }
}
