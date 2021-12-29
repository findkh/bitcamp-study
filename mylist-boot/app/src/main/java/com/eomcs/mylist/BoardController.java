package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() { //클라이언트 요청 처리
    return ArrayList.toArray(boardList); //배열을 다룸
  }

  @RequestMapping("/board/add")
  //스프링부트야 클라이언트가 보낸 값 Board 객체에 담아줘
  public Object add(Board board) { 
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    ArrayList.add(boardList, board);
    return boardList.size;
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size) {
      return "";
    }
    Board board = (Board) boardList.list[index];
    board.viewCount++;
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }

    Board old = (Board) boardList.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;

    return ArrayList.set(boardList, index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }

    return ArrayList.remove(boardList, index) == null? 0 : 1;
    //    return 1;
  }

}


