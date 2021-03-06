//220106 220107 220123 220124
package com.eomcs.basic.ex02;
// String - String 인스턴스를 상수풀에 생성하기: intern()

public class Exam0113 {
  public static void main(String[] args) {

    String s1 = new String("Hello"); //Heap에 String 인스턴스를 생성한다.

    // intern()
    // - String 객체를 들어 있는 문자열과 동일한 문자열을 갖고 있는 String 객체를 상수풀에서 찾는다.
    // - 있으면 그 String 객체의 주소를 리턴한다.
    // - 없으면 상수풀에 String 객체를 생성한 후 그 주소를 리턴한다.
    String s2 = s1.intern();

    String s3 = "Hello"; 
    // 해당 문자열을 가진 String 객체를 String Pool에서 찾는다
    //있으면 그 객체를 return한다.
    //없으면 새 객체를 만들고 return한다

    System.out.println(s1 == s2);
    System.out.println(s2 == s3);
  }
}


