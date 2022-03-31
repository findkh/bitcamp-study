package com.eomcs.mylist.service;

import com.eomcs.mylist.domain.Member;

public interface MemberService {

  int add(Member member);

  Member get(String email, String password);

  Member get(String email);

  //  List<Board> list();
  //
  //  Board get(int no);
  //
  //  int update(Board board);
  //
  //  int delete(int no);

}
