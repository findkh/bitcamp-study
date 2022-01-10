package com.eomcs.io;
import java.io.FileReader;

//기존 코드를 자신의 코드인양 사용하기 위해 해당 클래스를 포함한다.
public class FileReader2 {
  // 기존 클래스 포함!
  FileReader in;

  public FileReader2(String filename) throws Exception {
    //기존 객체를 준비한다.
    in = new FileReader(filename);
  }

  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;

    //입력을 수행하기 위해 이 클래스가 포함하고 있는 기존 객체를 이용한다.
    while ((c = in.read()) != -1) {
      if (c == '\n') { //읽은 문자가 줄바꿈 명령이라면
        return buf.toString(); // 버퍼에 저장한 문자를 문자열로 뽑아서 return 한다.
      } else if (c == '\r') {
        //무시 CR(Carrage Return; \r )코드는 버퍼에 담지 말고 버린다.
      } else {
        buf.append((char) c);
      }
    }
    return buf.toString(); //버퍼에 남은 것들 리턴한다.
  }

  //자원을 해제하라는 요청이 들어오면 실제 일을 하는 객체에게 전달한다.
  public void close() throws Exception {
    in.close();
  }
}
