package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;

@Mapper
public interface ContactDao {

  //Contact 테이블
  int countAll(); // <select id="com.eomcs.mylist.dao.ContactDao.countAll">..</select>

  List<Contact> findAll();

  int insert(Contact contact);

  Contact findByNo(int no);

  Contact findByEmail(String email);

  List<Contact> findByName(String name);

  int update(Contact contact);

  int delete(int no);

  //ContactTel 테이블
  List<ContactTel> findTelByContactNo(int contacNo);

  int insertTel(ContactTel tel);

  int insertTels(@Param("contactNo") int contactNo, @Param("tels") List<ContactTel> tels);
  //Param -> SQL Mapper에서 사용할 이름

  int updateTel(ContactTel tel);

  int deleteTel(int telNo);

  int deleteTelByContactNo(int contacNo);
}











