package com.eomcs.algorithm.data_structure.linkedlist2.step1;

public class Node {
  Node prev; //이전객체주소
  Object value; //Object로 해야 어떤 객체든 받을 수 있다.
  Node next; //다음객체주소

  //생성자를 준비한다.
  public Node() {}

  public Node(Object value) {
    this.value = value;
  }

  public Node(Object value, Node prev, Node next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}
