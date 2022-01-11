//220111
package com.eomcs.oop.ex05.a;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  //생성자들
  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  //실무에서 인스턴스 멤버를 쓰지 않는 메서드는 static으로 붙여야 한다.
  //상속을 배우기 때문에 인스턴스 메서드로 만들었음
  public void run() {
    System.out.println("달린다!");
  }
}


