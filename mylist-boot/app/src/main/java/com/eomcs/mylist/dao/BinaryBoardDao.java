package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import com.eomcs.mylist.domain.Board;

//인터페이스를 직접 구현하는 대신에 AbstractBoardDao 상속 받는다.
//@Repository 
public class BinaryBoardDao extends AbstractBoardDao {

  String filename = "boards.bin";


  public BinaryBoardDao() {

    try {
      DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

      int len = in.readInt();

      for (int i = 0; i < len; i++) { 
        Board board = new Board();
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setCreatedDate(Date.valueOf(in.readUTF()));
        board.setViewCount(in.readInt());

        boardList.add(board);

      }
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생");
    }
  }

  @Override
  protected void save() throws Exception { 
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

    //게시글 개수를 먼저 출력한다
    out.writeInt(boardList.size());

    //게시글을 순차적으로 출력한다.
    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.writeUTF(board.getTitle());
      out.writeUTF(board.getContent());
      out.writeUTF(board.getCreatedDate().toString());
      out.writeInt(board.getViewCount());
    }
    out.flush(); //버퍼에 남은 데이터 모두 출력
    out.close();
  }
}
