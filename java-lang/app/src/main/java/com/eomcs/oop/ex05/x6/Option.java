package com.eomcs.oop.ex05.x6;
//데코레이터 패턴
public abstract class Option extends Car {
  // 추상 클래스로 만듦

  Car car;


  //포함관계
  //생성자로 만듦
  public Option(Car car) {
    this.car = car;
  }

  @Override
  public void start() {
    //데코레이터는 자동차가 아니다.
    //따라서 시동을 걸라고 요청이 들어오면
    //실제 자동차 객체에게 위임해야 한다.
    car.start();
  }

  @Override
  public void stop() {
    //데코레이터는 자동차가 아니다.
    //따라서 시동을 끄라고 요청이 들어오면
    //실제 자동차 객체에게 위임해야 한다.
    car.stop();
  }
}
