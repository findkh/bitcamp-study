package com.eomcs.oop.ex05.x6;
// CarTest1과 CarTest2 모두 돌아가게 코드 수정함(실무에서 사용하는 방법)

public class Truck extends Car{

  int weight;

  @Override
  public void run() {
    //기존에 이미 있는 메서드를 호출한다.
    this.go();
  }

  @Override
  public void start() {
    this.luanch();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  public void luanch() {
    System.out.println("트럭 시동을 켠다");
  }

  public void stopping() {
    System.out.println("트럭 멈춘다");
  }

  public void go() {
    System.out.println("트럭 달린다");
  }

  public void dump() {
    System.out.println("트럭 짐 내린다");
  }
}
