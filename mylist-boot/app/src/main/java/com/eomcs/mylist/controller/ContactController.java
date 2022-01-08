package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;


@RestController 
public class ContactController {

  ArrayList contactList;

  public ContactController() throws Exception {
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!");

    FileReader in = new FileReader("contacts.csv");

    StringBuilder buf = new StringBuilder();

    int c;
    while (true) {
      c = in.read(); // 파일에서 한 문자를 읽는다.

      if (c == -1)//파일을 다 읽으면 -1을 return하니, -1이 나오면 반복문을 종료한다
        break; 

      if (c == '\n') {
        //Contact contact = new Contact(buf.toString()); 
        //객체를 만들 필요 없이 이 문장을 간소화 해서  add의 파라미터로 넘겨준다.
        //contactList.add(new Contact(buf.toString()));
        //파일에서 읽은 CSV 데이터로 객체를 초기화 시킨후 목록에 등록한다.

        contactList.add(Contact.valueOf(buf.toString())); //static 메서드를 사용했을 때
        //데이터를 사용하는 입장에서는 메서드만 호출하면 된다.

        buf.setLength(0); //다음 데이터를 읽기 위해 버퍼를 초기화 시킨다
        //버퍼 초기화를 하지 않으면 앞의 배열이 중복해서 출력된다.

      } else { //문자를 읽을 때 마다 버퍼에 임시 보관한다.
        buf.append((char) c);
      }
    }
    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }
    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("contacts.csv");

    Object[] arr = contactList.toArray();
    for (Object obj : arr) {
      Contact contact = (Contact) obj;
      //String.format 형식으로 코드를 개선한다.
      out.write(contact.toCsvString() + "\n");
      //한줄로된 csv형식의 연락처정보를 출력하고 개행
    }

    out.close();
    return arr.length;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;  
  }
}