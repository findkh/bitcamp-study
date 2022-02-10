package com.eomcs.oop.ex11.overview.step1;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length) >> 1); //기존보다 50% 더 큰 배열을 만듦
      //오른쪽으로 1비트를 이동하면 /2 한 것과 같다.
    }
    arr[size++] = obj;
  }

  public Object get(int index) /*ArrayIndexOutOfBoundsException 
  -> RuntimeException의 자손이기 때문에 메서드에 예외 선언 안해줘도 된다.*/{
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
    //배열의 크기를 줄이고, 마지막 항목에 들어 있는 값을 null로 초기화하여 객체의 레퍼런스를 줄인다.

    return old;
  }
}

