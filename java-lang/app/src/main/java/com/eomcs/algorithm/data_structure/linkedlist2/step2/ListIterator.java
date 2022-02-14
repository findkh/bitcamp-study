package com.eomcs.algorithm.data_structure.linkedlist2.step2;

// 컬렉션의 값을 조회하는 일을 수행한다.
//
public class ListIterator implements Iterator {

  LinkedList list;
  int cursor;

  public ListIterator(LinkedList list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() { //꺼낼 항목이 있으면 true next()를 실행함.
    return cursor < list.size();
  }

  @Override
  public Object next() {
    return list.get(cursor++);
    //    int temp = cursor;
    //    cursor = cursor + 1;
    //    return list.get(temp);
  }
}
