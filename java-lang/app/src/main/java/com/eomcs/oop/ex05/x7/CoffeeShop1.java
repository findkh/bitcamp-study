package com.eomcs.oop.ex05.x7;

public class CoffeeShop1 {
  public static void main(String[] args) {
    Americano americano = new Americano();
    CaffeLatte caffeelatte = new CaffeLatte();
    //객체 준비

    System.out.println("<<뜨거운 아메리카노>>");
    americano.SumIce(false);
    testAmericano(americano);
    System.out.println("===================");
    System.out.println("<<차가운 아메리카노>>");
    americano.SumIce(true);
    testAmericano(americano);

    System.out.println("===================");
    System.out.println("<<차가운 카페라떼 + 우유거품 O>>");
    caffeelatte.ice = true;
    CaffeLatte.MilkForm = true;
    testCaffeLatte(caffeelatte);
    System.out.println("===================");
    System.out.println("<<뜨거운 카페라떼 + 우유거품 X>>");
    caffeelatte.ice = false;
    CaffeLatte.MilkForm = false;
    testCaffeLatte(caffeelatte);

  }

  static void testAmericano(Americano coffee) {
    coffee.Cup();
    coffee.Cold();
    coffee.Espresso();
    coffee.makeCoffee();
  }

  static void testCaffeLatte(CaffeLatte coffee) {
    coffee.Cup();
    coffee.Cold();
    coffee.Espresso2();
    coffee.SteamedMilk();
    coffee.SumMilkForm();
    coffee.makeCoffee2();
  }
}
