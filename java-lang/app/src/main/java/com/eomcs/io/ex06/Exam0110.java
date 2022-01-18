//220118
package com.eomcs.io.ex06;
// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    //파일 읽기
    //SSD나 HDD에서 파일을 읽는 시간
    //= 1byte씩 읽는 시간

    int b;

    long startTime = System.currentTimeMillis(); //  밀리초(1/1000)

    int callCount = 0;
    while ((b = in.read()) != -1) {
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);

    in.close();
  }

}
