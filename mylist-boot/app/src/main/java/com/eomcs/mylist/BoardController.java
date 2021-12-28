package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  @RequestMapping("/board/list")
  public Object list() { //클라이언트 요청 처리
    return ArrayList3.toArray(); //배열을 다룸
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    ArrayList3.add(board);
    return ArrayList3.size;
  }

  @RequestMapping("/board/get")
  public Object get(String title) {
    int index = indexOf(title);
    if (index == -1) {
      return "";
    }
    return ArrayList3.list[index];
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    int index = indexOf(board.title);
    if (index == -1) {
      return 0;
    }
    return ArrayList3.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(String title) {
    int index = indexOf(title);
    if (index == -1) {
      return 0;
    }

    ArrayList3.remove(index);
    return 1;
  }

  static int indexOf(String title) {
    for (int i = 0; i < ArrayList3.size; i++) {
      Board board = (Board) ArrayList3.list[i];
      if (board.title.equals(title)) { 
        return i;
      }
    }
    return -1;
  }
}


