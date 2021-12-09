package com.eomcs.lang.ex05;
//211208 211209
//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0430 {
  public static void main(String[] args) {
    // >>> 비트 이동 연산자 사용법
    // - 오른쪽으로 비트를 이동시킨다.
    // - 왼쪽 빈자리를 음수 양수 상관없이 무조건 0으로 채운다.
    // - 오른쪽 경계를 넘어간 비트는 자른다.
    //
    int i = 105; // [00000000000000000000000001101001]

    System.out.println(i); //                       => 105


    System.out.println(i >>> 1);
    // [ 0000000000000000000000000110100]1
    // [00000000000000000000000000110100]1          => 52

    System.out.println(i >>> 2);
    // [  000000000000000000000000011010]01
    // [00000000000000000000000000011010]01         => 26

    System.out.println(i >>> 3);
    // [   00000000000000000000000001101]001
    // [00000000000000000000000000001101]001        => 13

    System.out.println(i >>> 4);
    // [    0000000000000000000000000110]1001
    // [00000000000000000000000000000110]1001       => 6
  }
}
