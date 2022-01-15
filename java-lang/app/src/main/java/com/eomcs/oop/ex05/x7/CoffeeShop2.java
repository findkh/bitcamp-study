package com.eomcs.oop.ex05.x7;

public class CoffeeShop2 {
  public static void main(String[] args) {
    Americano americano = new Americano();
    CaffeLatte caffeelatte = new CaffeLatte();
    VanillaLatte vanillalatte = new VanillaLatte();

    System.out.println("<<차가운 아메리카노>>");
    americano.SumIce(true);
    testMakeCoffee(americano);
    System.out.println("===================");

    System.out.println("<<차가운 카페라떼 + 우유거품 O>>");
    caffeelatte.SteamedMilk();
    caffeelatte.Cold2(true);
    CaffeLatte.MilkForm = true;
    testMakeCoffee(caffeelatte);
    caffeelatte.SumMilkForm();
    System.out.println("===================");

    System.out.println("<<차가운 바닐라라떼>>");
    vanillalatte.SumIce(true);
    vanillalatte.syrup = true;
    testMakeCoffee(vanillalatte);
    System.out.println("===================");

    System.out.println("<<뜨거운 바닐라라떼>>");
    vanillalatte.SumIce(false);
    vanillalatte.syrup = true;
    testMakeCoffee(vanillalatte);
  }

  static void testMakeCoffee(Coffee coffee) { 
    coffee.Cup();
    coffee.Cold();
    coffee.Espresso();
    coffee.makeCoffee();
  }
}

