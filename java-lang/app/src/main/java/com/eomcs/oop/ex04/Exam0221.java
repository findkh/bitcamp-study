//220106 220107
package com.eomcs.oop.ex04;
// Inteeger 클래스 : new Ingerger() VS Integer.valueOf

public class Exam0221 {
  public static void main(String[] args) throws Exception {
    // 다음과 같이 생성자를 통해 Integer 객체를 생성할 수 있지만,
    // 이 생성자는 사용하지 말라고 권고한 것이기 때문에 
    // 가능한 개발 중에 사용하지 말라!
    Integer obj1 = new Integer(100);
    Integer obj2 = new Integer(200);
    Integer obj3 = new Integer(300);

    Integer i1 = Integer.valueOf(127);
    Integer i2 = Integer.valueOf(127);
    Integer i3 = Integer.valueOf(127);


    //1) 생성자를 통해 객체를 만들면 무조건 새 객체를 만든다
    System.out.println(obj1 == obj2);
    System.out.println(obj1 == obj3);
    System.out.println(obj2 == obj3);

    System.out.println("---------------");

    //2) valueOf()를 통해 객체를 만들면 자주 쓰는 값(-128 ~ + 127)에 대해서만 한 번만 만들어 공유한다.
    System.out.println(i1 == i2);
    System.out.println(i1 == i3);
    System.out.println(i2 == i3);

  }
}





