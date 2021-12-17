package com.eomcs.lang.ex07;
//211217
//while문 for문으로 변환

import java.util.Scanner;

public class Exam0110Test2 {
  //1. 공백 출력 코드 메서드로 추출하기
  static void printSpace(int len) {
    for(int spaceCnt = 1; spaceCnt <= len; spaceCnt++) {
      System.out.print(" ");
    }
  }

  //2. 별을 출력하는 코드를 메서드로 추출하기
  static void printStars(int len) {
    for(int starCnt = 1; starCnt <= len; starCnt++) {
      System.out.print("*");
    }
  }

  //3. 공백 계산 식을 메서드로 추출하기
  static int getSpaceLength(int totalStar, int displayStar) {
    return (totalStar - displayStar) / 2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for(int starLen = 1; starLen <= len; starLen +=2) {
      printSpace(getSpaceLength(len, starLen));
      printStars(starLen);
      System.out.println();
    }
  }
}
