package com.eomcs.lang.ex04;
//211206
//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다. 
// 
public class Exam0951 {
  public static void main(String[] args) {

    byte b = Byte.valueOf("100");
    short s = Short.valueOf("32767");
    int i1 = Integer.parseInt("123");
    int i2 = Integer.valueOf("123");
    long l = Long.valueOf("922111222233331111");
    float f1 = Float.valueOf("3.14f");
    float f2 = Float.parseFloat("3.14f");
    double d = Double.valueOf("9876.54321");
    boolean bool1 = Boolean.valueOf("1"); 
    boolean bool2 = Boolean.parseBoolean("0"); 
    char c = "가".charAt(0);



    //문자열 -> boolean 값으로 바꿈

    //문자열 -> character로 바꿈

    System.out.println(b);
    System.out.println(s);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(l);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(bool1);
    System.out.println(bool2);
    System.out.println(c);
  }
}
