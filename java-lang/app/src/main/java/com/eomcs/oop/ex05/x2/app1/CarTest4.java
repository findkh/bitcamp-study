package com.eomcs.oop.ex05.x2.app1;

import com.eomcs.oop.ex05.x2.Engine;

//하이브리드 자동차 만들기

//1. 기존 코드의 기능을 덧붙이기.
public class CarTest4 {

  public static void main(String[] args) {
    //Engin 클래스에 시동걸고 끄는 기능을 추가한다.
    // -> start(), stop() 메서드 추가
    // -> run 메서드 연결



    Engine car = new Engine();
    car.chargeBattery(100);
    car.start();
    car.run();
    car.stop();

  }
}
