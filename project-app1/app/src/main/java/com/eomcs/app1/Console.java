package com.eomcs.app1;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

  Scanner keyScan = new Scanner(System.in);

  Command prompt() {
    System.out.print("> ");
    String[] values = keyScan.nextLine().split(" "); // add 100 200가 있으면
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length)); 
    //파라미터를 2개로 나눠서 배열의 0번지는 명령어 이름으로 하고 나머지는 따로 파라미터로 받겠다는 뜻이다.
  }

  void close() {
    keyScan.close();
  }
}
