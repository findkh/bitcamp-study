package com.eomcs.oop.ex05.x6;

public class CarTest2 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    testCar(sedan);

    System.out.println("=============");

    Truck truck = new Truck();
    testCar(truck);

    System.out.println("=============");


    Suv suv = new Suv();
    suv.actvie4wd = false;
    testCar(suv);
  }

  //같은 종류가 되는 순간 test car 하면 됨 전처럼 따로 만들지 마
  //카 종류만 test합니다!! 다른 종류 안합니다!! 
  static void testCar(Car car) { //다형적 변수의 특징
    car.start();
    car.run();
    car.stop();
  }
}
