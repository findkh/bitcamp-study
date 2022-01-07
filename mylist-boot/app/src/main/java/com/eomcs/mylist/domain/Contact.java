package com.eomcs.mylist.domain;

public class Contact {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출됨");
  }

  public Contact(String csvStr) {
    // 예) String csvStr = buf.toString(); // "홍길동,hong@test.com,1111-1111,비트캠프"
    String[] value = csvStr.split(","); // "["홍길동","hong@test.com","1111-1111","비트캠프"]
    this.setName(value[0]); // 파일에 들어 있는 각 항목을 객체의 필드에 저장한다.
    this.setEmail(value[1]);
    this.setTel(value[2]);
    this.setCompany(value[3]);
  }

  //적용기술
  //-> 스태틱 메서드 : 특정 인스턴스에 종속 되지 않고 사용하는 메서드  
  public static Contact valueOf(String csvStr) {
    String[] value = csvStr.split(","); // "["홍길동","hong@test.com","1111-1111","비트캠프"]

    Contact contact = new Contact();
    contact.setName(value[0]); // 파일에 들어 있는 각 항목을 객체의 필드에 저장한다.
    contact.setEmail(value[1]);
    contact.setTel(value[2]);
    contact.setCompany(value[3]);

    return contact;
  }

  //적용기술
  //=> 인스턴스 메서드 : 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라(Static 안붙임)
  //=> GRASP의 Information Expert 패턴
  //    데이터를 가공하는 기능은 그 데이터를 갖고 있는 클래스에 둬야 한다.
  public String toCsvString() {
    return String.format("%s,%s,%s,%s", 
        this.getName(), 
        this.getEmail(), 
        this.getTel(), 
        this.getCompany());
  }

  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


}
