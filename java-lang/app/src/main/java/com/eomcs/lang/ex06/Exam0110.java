package com.eomcs.lang.ex06;
//211210
//# 흐름 제어문 - 조건문 if
//
public class Exam0110 {
  public static void main(String[] args) {
    int age = 17;

    // => if (조건) 문장;
    if (age >= 19) System.out.println("1 성인이다.");

    // => 문장을 다른 줄에 놓는 경우가 많다.
    if (age >= 19); // if 문에 빈 문장을 넣을 수 있다.
    System.out.println("2 성인이다.");
    // 이런 경우 개발자가 오해할 수 있다.
    // if (조건) 뒤에 문자의 끝을 표시하는 세미콜론을 사용하지 않도록 조심하라!

    if (age >= 19) {
      System.out.println("4 성인이다");
    }

    // 참고!
    // => 문장을 작성할 때 연산자, 피연산자, 문장 기호에 따라 여러 줄에 걸쳐 작성할 수 있다.
    // => 단 문장을 여러 줄로 나누어 작성할 때, 읽기 쉽게 작성하라.
    // => 다음과 같이 하지 말라!
    if (
        age
        >=
        19
        ) 
      System
      .
      out.
      println(
          "3 성인이다.")
      ;
  }
}
/*
# if 조건문
문법1:
  if (조건) 문장1;
  => 조건이 참일 때 문장1을 수행한다.

문법2:
  if (조건) 문장1; else 문장2;
  => 조건이 참일 때 문장1을 수행하고, 거짓이면 문장2를 수행한다.
 */