package com.eomcs.oop.ex11.overview.step6;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length) >> 1);
    }
    arr[size++] = obj;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return arr[index];
  }

  public int size() {
    return size;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }

    Object old = arr[index];

    for (int i = index; i < (size - 1); i++) {
      arr[i] = arr[i + 1];
    }

    arr[--size] = null;

    return old;
  }

  public Iterator iterator() {
    //local class(로컬 클래스)
    // - 메서드나 특정 블록 안에서만 사용될 메서드라면 사용 범위를 더 제한 할 수 있다.
    //   그 메서드나 블록에서 클래스를 정의함으로써 명시적으로 사용 범위를 더 제한할 수 있다.
    // - 단지 사용 범위를 더 제한한 것이다.
    // - 로컬 클래스에도 바깥 클래스의 인스턴스 주소를 저장할 필드와 생성자가 자동으로 추가된다.
    class ListIterator implements Iterator {

      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < MyList.this.size();
      }

      @Override
      public Object next() {
        return MyList.this.get(cursor++);
      }
    }

    return new ListIterator();
  }
}

