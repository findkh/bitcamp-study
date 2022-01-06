//220106
package com.eomcs.basic.ex02;
// String - String 객체와 문자열 리터럴의 타입

public class Exam0112 {
  public static void main(String[] args) {

    String s1 = new String("Hello"); //Heap 영역에 String 인스턴스를 만든다.
    String s2 = "Hello"; //String Pool 영역에 String 인스턴스를 만든다.
    //우변에 리터럴을 주면 String Pool에 저장함
    //다음에 똑같은 문자열을 만들면 기존에 만들어진 주소를 리턴함.

    // 문자열 리터럴이 String 객체인지 확인해보자.
    System.out.println(s1 == s2);
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
  }
}


