package com.eomcs.app2.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

//파일에서 데이터를 저장하고 꺼내는 일은 서버에서한다. 클라이언트에서는 하지 않는다.

public class ScoreHandler {

  ObjectInputStream in;
  ObjectOutputStream out;

  public ScoreHandler(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  //서버와 약속(serverApp의 switch문)과 맞게 코딩되어야 한다.
  public void create() throws Exception {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어? "));
    score.setEng(Prompt.promptInt("영어? "));
    score.setMath(Prompt.promptInt("수학? "));

    out.writeUTF("insert");
    out.writeObject(score);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) { //서버에서 sucess라 응답이 오면
      int count = in.readInt(); //서버가 보낸 count를 읽어서 count에 저장한다.
      if(count == 1) {
        System.out.println("입력했습니다");
      } else {
        System.out.println("입력하지 못했습니다.");
      }
    } else {
      System.out.println(in.readUTF()); //에러가난 이유를 읽어서 출력한다.
    }
  }

  public void list() throws Exception {
    out.writeUTF("selectList");
    out.flush();

    String status = in.readUTF(); //서버가 보낸 응답을 읽는다.
    if (status.equals("success")) {
      Score[] scores = (Score[]) in.readObject(); //서버에서 배열로 보내니까 Score의 배열로 형변환한다.
      int count = 0;
      for (Score score : scores) {
        System.out.printf("%d: %s, %d, %.1f\n",
            count++,
            score.getName(),
            score.getSum(),
            score.getAverage());
      }

    } else {
      System.out.println(in.readUTF()); //에러 출력
    }
  }

  public void detail() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) { //서버에서 sucess라 응답이 오면
      Score score = (Score) in.readObject();
      System.out.printf("이름: %s\n", score.getName());
      System.out.printf("국어: %d\n", score.getKor());
      System.out.printf("영어: %d\n", score.getEng());
      System.out.printf("수학: %d\n", score.getMath());
      System.out.printf("합계: %d\n", score.getSum());
      System.out.printf("평균: %.1f\n", score.getAverage());

    } else {
      System.out.println(in.readUTF()); //에러가난 이유를 읽어서 출력한다.
    }
  }

  public void update() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) { //서버에서 sucess라 응답이 오면
      Score old = (Score) in.readObject();

      Score score = new Score();
      score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
      score.setKor(Prompt.promptInt("국어(%d)? ", old.getKor()));
      score.setEng(Prompt.promptInt("영어(%d)? ", old.getEng()));
      score.setMath(Prompt.promptInt("수학(%d)? ", old.getMath()));

      out.writeUTF("update");
      out.writeInt(no);
      out.writeObject(score);
      out.flush();

      status = in.readUTF();
      if (status.equals("success")) {
        int count = in.readInt();
        if(count == 1) {
          System.out.println("변경했습니다");
        } else {
          System.out.println("변경하지 못했습니다.");
        }
      } else {
        System.out.println(in.readUTF());
      }

    } else {
      System.out.println(in.readUTF()); //에러가난 이유를 읽어서 출력한다.
    }
  }

  public void delete() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("delete");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      int count = in.readInt();
      if(count == 1) {
        System.out.println("삭제했습니다");
      } else {
        System.out.println("삭제하지 못했습니다.");
      }
    } else {
      System.out.println(in.readUTF());
    }
  }
}
