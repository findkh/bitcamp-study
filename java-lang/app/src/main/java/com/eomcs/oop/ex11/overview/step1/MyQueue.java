package com.eomcs.oop.ex11.overview.step1;

public class MyQueue extends MyList {
  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if (size == 0) {
      return null;
    }
    return remove(0); //맨 앞에 것을 꺼내주고 제거 한다.
  }
}

