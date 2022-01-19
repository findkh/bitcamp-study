//220119
package com.eomcs.io.ex08;
// 포함 관계로 기능 확장하기 - BufferedInputStream, BufferedOutputStream

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    BufferedInputStream in2 = new BufferedInputStream(in); // 버퍼에 하나씩 담아뒀다가 리턴함

    FileOutputStream out = new FileOutputStream("temp/jls11_3.pdf");
    BufferedOutputStream out2 = new BufferedOutputStream(out); //버퍼가 꽉차면 출력함

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((b = in2.read()) != -1)
      out2.write(b);

    // 아직 파일로 출력되지 않고 버퍼 남아 있는 데이터를
    // 마무리로 출력한다.
    out2.flush();

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in2.close();
    out2.close();
  }
}


