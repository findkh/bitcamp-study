package com.eomcs.lang.ex07;
//211217
//while문 for문으로 변환

import java.util.Scanner;

public class Exam0110Test2 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for(int starLen = 1; starLen <= len; starLen +=2) {
      int spaceLen = (len - starLen) / 2;
      for(int spaceCnt = 1; spaceCnt <= spaceLen; spaceCnt++) {
        System.out.print(" ");
      }
      // 별 출력
      for(int starCnt = 1; starCnt <= starLen; starCnt++) {
        System.out.print("*");
      }

      // 출력 줄 바꾸기
      System.out.println();

    }
  }
}
