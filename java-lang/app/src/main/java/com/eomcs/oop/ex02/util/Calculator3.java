package com.eomcs.oop.ex02.util;
//220103
public class Calculator3 {

  public int result = 0;

  public void plus(int value) {
    result += value;
  }

  public void minus(int value) {
    result -= value;
  }

  public void multiple(int value) {
    result *= value;
  }

  public void divide(int value) {
    result /= value;
  }

  public static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }

  public int getResult() {
    return this.result;
  }
}

