package com.eomcs.lang.ex05;
//211209
//# 증감 연산자 : 후위(post-fix) 증감 연산자 응용 II
//
public class Exam0640 {
  public static void main(String[] args) {
    int i = 2;
    int result = i++ + i++ * i++;
    // 연산자 우선수위: 
    // 1) ++, --  증감연산자를 제일 먼저 처리해야 한다 증감연산자 처리 후에 산술연산한다.
    // 2) *, /, %
    // 3) +, -
    // 4) =
    // 
    // int result = 2 + i++ * i++;  => i = 3
    // int result = 2 + 3 * i++; => i = 4
    // int result = 2 + 3 * 4; => i = 5
    // int result = 2 + 12;
    // int result = 14;
    System.out.printf("%d, %d\n", i, result);

  }
}
