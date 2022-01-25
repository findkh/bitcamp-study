package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Contact;

//BoardDao의 인터페이스 정의(규칙을 정의한다)

public interface ContactDao { 

  int countAll();

  Object[] findAll();

  void insert(Contact contact) throws Exception;

  Contact findByEmail(String email);

  int update(Contact contact) throws Exception;

  int delete(String Email) throws Exception;

}
