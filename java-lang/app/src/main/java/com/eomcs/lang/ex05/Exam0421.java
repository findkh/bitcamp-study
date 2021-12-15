package com.eomcs.lang.ex05;
//211208 211209 211215
//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0421 {
  public static void main(String[] args) {
    // 음수일 경우,
    // - 빈자리는 1로 채운다.
    //
    int i = -87; // [11111111111111111111111110101001]

    System.out.println(i); //                   => -87

    System.out.println(i >> 1);
    // [ 1111111111111111111111111010100]1
    // [11111111111111111111111111010100]1      => -44

    System.out.println(i >> 2);
    // [  111111111111111111111111101010]01
    // [11111111111111111111111111101010]01     => -22

    System.out.println(i >> 3);
    // [   11111111111111111111111110101]001
    // [11111111111111111111111111110101]001    => -11

    System.out.println(i >> 4);
    // [    1111111111111111111111111010]1001
    // [11111111111111111111111111111010]1001    => -6

    // 음수 값에 대해 오른쪽으로 비트 이동
    // => 2**n으로 나눈 것과 같다.
    // => 소수점이 있을 경우 그 수 보다 바로 밑 정수 값이 결과이다.
    // => 왼쪽 빈자리가 부호비트로 채워진다.
  }
}








