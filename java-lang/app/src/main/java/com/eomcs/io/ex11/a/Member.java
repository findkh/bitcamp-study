package com.eomcs.io.ex11.a;

public class Member {
  String name;
  int age;
  boolean gender; // true(여자), false(남자)

  @Override
  public String toString() { //this 생략
    return "Member [name=" + /*this.*/name + ", age=" + age + ", gender=" + gender + "]";
  }
}
