package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  @RequestMapping("/board/list")
  public Object list() { //클라이언트 요청 처리
    return ArrayList3.toArray(); //배열을 다룸
  }

  @RequestMapping("/board/add") 
  public Object add(Board board) { //야 스프링부트 클라이언트가 보낸 값 Board 객체에 담아줘
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    ArrayList3.add(board);
    return ArrayList3.size;
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return "";
    }
    Board board = (Board) ArrayList3.list[index]; //list는 object 배열임 하위 분류명은 상위 분류명을 못가르킨다
    //Object는 Board의 상위 버전이다.  Board로 형변환 해야 한다. 
    board.viewCount++;
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }

    //기존 객체를 새 객체로 바꾸기 전에 조회수와 등록일을 복사 해놓는다.
    Board old = (Board) ArrayList3.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;

    return ArrayList3.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }
    ArrayList3.remove(index);
    return 1;
  }
}


