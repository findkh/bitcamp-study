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
    //

    //String csvStr = "홍길동,hong@test.com,010-111-222,비트캠프"
    //생성자가 호출될 때 콤마로 잘라서 초기화 시키기 위해 이 작업을 한다.
    String[] values = csvStr.split(","); //ex) ["홍길동","hong@test.com","010-111-222","비트캠프"]
    this.setName(values[0]); 
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);
  }

  //위 Contact는 객체를 만든 다음 파라미터로 넘어온 csv 데이터를 파싱한 후 배열을 만들어서 그 배열 값을 인스턴스 변수로 넣는다면
  //밑 valueOf는 csv 문자열을 주면 새로운 contact 객체를 만들어 리턴한다


  //적용기술
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지 않고 사용하는 메서드
  // => GoF의 'Factory Method' 패턴
  //    객체 생성 과정이 복잡할 경우 new 명령을 통해 직접 객체를 생성하는 대신
  //    메서드를 통해 객체를 리턴 받는다.
  //    이렇게 객체를 만들어주는 메서드를 "공장 메서드(factory method)"라 부른다
  //    보통 스태틱 메서드로 정의한다.
  //
  public static Contact valueOf(String csvStr) { //contact객체를 리턴한다

    String[] values = csvStr.split(","); //ex) ["홍길동","hong@test.com","010-111-222","비트캠프"]

    Contact contact = new Contact();
    //new 명령어를 메서드 안으로 숨긴다. -> 이것이 캡슐화! 

    contact.setName(values[0]); 
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);

    return contact;
  } 

  //인스턴스 메서드 
  //    -> 특정 인스턴스를 사용한다면 인스턴스 메서드로 만든다
  //       인스턴스 메서드는 내장변수 this가 있다. 
  //       this안에 있는 연락처 객체들을 꺼내서 문자열로 만든다
  //GRASP의 Information Expert 패턴
  //    -> 데이터를 가공하는 일은 데이터를 가지고 있는 클래스에 둬야 한다!!!!!!!!!
  public String toCsvString() {
    return String.format("%s,%s,%s,%s",
        //enter는 출력하는 쪽에서 할일이라 뺐다.
        this.getName(),
        this.getEmail(),
        this.getTel(),
        this.getCompany());
    //이렇게 csv형식으로 문자열을 리턴한다.
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