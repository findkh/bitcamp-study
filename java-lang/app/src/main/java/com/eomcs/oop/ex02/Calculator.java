package com.eomcs.oop.ex02;
//211231 220103 220104
//메서드에 static을 붙일지 안붙일지의 여부
//인스턴스 변수를 사용해야 한다면 non-static 메서드로 만든다
//인스턴스 변수를 사용하지 않는다면 static 메서드로 만든다

class Calculator {

  int result = 0;

  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }

  void divide(int value) {
    this.result /= value;
  }

  // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }

  public int getResult() {
    return this.result;
  }
}
