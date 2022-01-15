package com.eomcs.oop.ex05.x7;

public class CoffeeShop3 {
  public static void main(String[] args) {
    VanillaLatte vanillalatte = new VanillaLatte();
    Americano americano = new Americano();

    System.out.println("<<테이크아웃 - 비닐라 라떼 L>>");
    Takeout takeout = new Takeout(vanillalatte);
    vanillalatte.coffeeSize = 'L';
    vanillalatte.syrup = true;
    testMakeCoffee(takeout);

    System.out.println("============================");
    System.out.println("<<딜리버리 - 비닐라 라떼>>");
    Delivery delivery2 = new Delivery(vanillalatte);
    vanillalatte.coffeeSize = 'M';
    vanillalatte.syrup = true;
    testMakeCoffee(delivery2);

    System.out.println("============================");
    System.out.println("<<딜리버리 - 아메리카노>>");
    Delivery delivery = new Delivery(americano);
    testMakeCoffee(delivery);
  }


  static void testMakeCoffee(Coffee coffee) { 
    coffee.Cup();
    coffee.Cold();
    coffee.Espresso();
    coffee.makeCoffee();
  }
}

