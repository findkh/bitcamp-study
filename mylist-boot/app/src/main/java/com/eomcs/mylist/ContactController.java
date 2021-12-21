package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController {

  Contact[] contacts = new Contact[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    Contact[] arr = new Contact[size]; 
    for (int i = 0; i < size; i++) { 
      arr[i] = contacts[i]; 
    }
    return arr; 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    System.out.println(contact);

    if (size == contacts.length) {
      contacts = grow();
    }

    contacts[size++] = contact;

    return size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    contacts[index] = contact;
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    remove(index);
    return 1;
  }

  //1단계 : 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  //createCSV를 정의한후 add와 update를 수정해준다
  //더이상 안씀
  //    String createCSV(String name, String email, String tel, String company) {
  //      return name + "," + email + "," + tel + "," + company;
  //    }

  //  //2단계 : 이메일로 연락처를 찾아 배열 인덱스를 알아내는 코드를 분리한다.
  //  //indexOf() 정의한 후 get과 update를 변경한다.
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      Contact contact = contacts[i];
      if (contact.email.equals(email)) { 
        return i;
      }
    }
    return -1;
  }

  //  //3단계 : 배열 항목 삭제 코드를 분리한다.
  //remove() 정의, delete를 변경한다
  Contact remove(int index) {
    Contact old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i];
    }
    size--;
    return old;
  }

  //4단계 : 배열 크기를 자동으로 늘린다
  //add 변경
  /*
     @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    if (size == contacts.length) {
      int newCapacity = contacts.length + (contacts.length >> 1);
      String[] arr = new String[newCapacity];

      for (int i = 0; i < contacts.length; i++) {
        arr[i] = contacts[i];
      }

      contacts = arr;
    }
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }
   */

  //5단계 : 배열 크기를 늘리는 코드를 별도의 메서드로 분리한다
  //grow() 생성후 add 변경
  Contact[] grow() {
    Contact[] arr = new Contact[newLength()];
    copy(contacts, arr);
    return arr;
  }


  //6단계 : 배열 크기를 계산하는 코드를 별도의 메서드로 분리한다. 
  //newLength() 생성후 grow() 변경
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }

  //7단계 : 배열을 복사하는 코드를 메서드로 분리한다. 
  //copy() 생성하고 grow를 변경한다.
  //개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다. 
  // 즉 target 배열이 source 배열보다 작을 경우 target 배열 크기만큼만 복사한다.
  void copy(Contact[] source, Contact[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

}


