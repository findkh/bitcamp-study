package com.eomcs.util;

import java.util.Scanner;
//복잡한 코드를 메서드나 클래스로 포장해두는 것이 캡슐화이다.
//쓰는 입장에서는 단순한 상황만 제공한다.

public class Prompt {
  static Scanner keyScan = new Scanner(System.in);

  public static int promptInt(String titleFormat, Object... args) {
    return Integer.parseInt(promptString(titleFormat, args));
  }

  public static String promptString(String titleFormat, Object... args) {
    System.out.print(String.format(titleFormat, args));
    return keyScan.nextLine();
  }
}
