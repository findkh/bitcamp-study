//220113
package com.eomcs.oop.ex05.x5;

public class CarTest3 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();

    ElectricEngine engineOption = new ElectricEngine(sedan);
    //engineOption.chargeBattery(100);

    Trailer trailer = new Trailer(sedan);
    trailer.start();
    trailer.run();
    trailer.stop();

    System.out.println("----------");

    Truck truck = new Truck();

    ElectricEngine engineOption2 = new ElectricEngine(truck);
    engineOption2.chargeBattery(100);
    engineOption2.start();
    engineOption2.run();
    engineOption2.stop();
  }
}
