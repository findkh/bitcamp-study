package com.eomcs.oop.ex05.x7;

public abstract class Option extends Coffee {

  Coffee coffee;

  //포함관계
  //생성자로 만든다
  public Option(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public void Cup() {
    coffee.Cup();
  }

  @Override
  public void Cold() {
    coffee.Cold();
  }

  @Override
  public void Espresso() {
    coffee.Espresso();
  }
}
