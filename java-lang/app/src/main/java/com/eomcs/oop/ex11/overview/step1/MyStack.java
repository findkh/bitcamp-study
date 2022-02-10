package com.eomcs.oop.ex11.overview.step1;

import java.util.EmptyStackException;

public class MyStack extends MyList {

  public void push(Object obj) {
    this.add(obj);
  }

  public Object pop() { //pop은 맨 마지막부터 꺼낸다.
    if (size == 0) {
      throw new EmptyStackException(); //더이상 꺼낼 것이 없다면 에러를 띄운다.
    }
    return remove(size - 1); //맨끝 항목을 삭제함
  }
}
