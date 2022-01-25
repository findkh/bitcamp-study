package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.eomcs.mylist.domain.Board;

//데이터 처리를 하는 클래스!!!
//@Repository 
public class CsvBoardDao extends AbstractBoardDao { 

  String filename = "boards.csv";

  public CsvBoardDao() {

    try {
      BufferedReader in = new BufferedReader(new FileReader(filename));

      String csvStr;
      while ((csvStr = in.readLine()) != null) { //readLine()은 스트림을 다 읽으면 null을 리턴함
        boardList.add(Board.valueOf(csvStr)); //boardList에 this가 생략되어 있다.
      }
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생");
    }
  }

  @Override
  protected void save() throws Exception { //추가 변경 삭제 할 때 마다 자동으로 변경되게 수정함. 내부적으로 호출하게 private으로 변경함
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.println(board.toCsvString());
    }
    out.flush(); //버퍼에 남은 데이터 모두 출력
    out.close();
  }
}
