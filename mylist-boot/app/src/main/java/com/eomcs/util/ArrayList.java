package com.eomcs.util;

public class ArrayList implements java.io.Serializable {

  Object[] list = new Object[5];
  int size = 0;

  //기본 생성자
  public ArrayList() {}

  //배열을 주면서 ArrayList[] 만들어 달라고 하면 쓰는 생성자
  public ArrayList(Object[] arr) {
    this.addAll(arr);
  }

  public void add(Object obj) {
    if (this.size == this.list.length) {
      this.list = this.grow();
    }
    this.list[this.size++] = obj;
  }

  //addAll 추가
  //배열을 파라미터로 받으면 바로 add() 메서드 호출해서 배열을 만든다.
  public void addAll(Object[] arr) {
    for (Object obj : arr) {
      this.add(obj);
    }
  }

  Object[] grow() {
    Object[] arr = new Object[newLength()];
    this.copy(arr);
    return arr;
  }

  int newLength() {
    return this.list.length + (this.list.length >> 1);
  }

  void copy(Object[] target) {
    int length = this.list.length;
    if (target.length < this.list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object remove(int index) {
    Object old = this.list[index];
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.size--;
    return old;
  }

  public Object set(int index, Object obj) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object old = this.list[index];
    this.list[index] = obj;
    return old;
  }

  public int size() {
    //  return this.size; //this 생략 가능
    return size;
  }

  public Object get(int index) {
    return this.list[index];
  }
}
