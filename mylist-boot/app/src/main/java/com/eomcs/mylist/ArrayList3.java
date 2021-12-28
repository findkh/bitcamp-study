package com.eomcs.mylist;

public class ArrayList3 {
  static Object[] list = new Object[10]; 
  //레퍼런스배열이 다양한 타입의 객체 주소를 받을 수 있도록 Object로 변경
  static int size = 0;

  static void add(Object obj) { //add의 파라미터 타입 변경
    //어떤 값이든 받아서 넣을 수 있게 Object로 파라미터를 받는다.
    if (size == list.length) { 
      list = grow();
    }
    list[size++] = obj;
  }

  static Object[] grow() {
    Object[] arr = new Object[newLength()];
    copy(list, arr);
    return arr;
  }

  static int newLength() {
    return list.length + (list.length >> 1);
  }

  static void copy(Object[] source, Object[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  static Object[] toArray() {
    Object[] arr = new Object[size]; 
    for (int i = 0; i < size; i++) { 
      arr[i] = list[i]; 
    }
    return arr; 
  }

  static Object remove(int index) {
    Object old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }

  static Object set(int index, Object obj) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object old = list[index];
    list[index] = obj;
    return old;
  }
}
