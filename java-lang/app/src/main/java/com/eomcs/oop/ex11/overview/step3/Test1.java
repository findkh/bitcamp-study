package com.eomcs.oop.ex11.overview.step3;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList();
    myList.add("홍길동");
    myList.add("임꺽정");
    myList.add("유관순");
    myList.add("안중근");
    myList.add("윤봉길");
    myList.add("김구");

    //Test1 클래스는 Interator의 구현체를 리턴한다는 것만 안다.
    Iterator iterator = myList.iterator(); 
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
