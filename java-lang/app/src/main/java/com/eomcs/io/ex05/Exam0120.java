//220118
package com.eomcs.io.ex05;
// 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기 

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test4.data");

    Member member = null;

    member = new Member();

    //출력된 순서에 따라 그대로 읽어야 한다.
    // 1) 이름 읽기
    int size = in.read(); // 이름이 저장된 바이트 배열의 수
    byte[] buf = new byte[size]; //사이즈 만큼 배열을 준비한다.
    in.read(buf); // 이름 배열 개수 만큼 바이트를 읽어 배열에 저장한다. 배열 크기만큼 읽어서 버퍼에 채운다.
    member.name = new String(buf, "UTF-8"); 
    //UTF-8 규칙에 따라 저장된 버퍼의 숫자들을 JVM이 읽을 수 있게 UTF-16으로 변환하여
    //name으로 한다.

    // 2) 나이(int) 읽기
    member.age = in.read() << 24;
    member.age += in.read() << 16;
    member.age += in.read() << 8;
    member.age += in.read();

    // 3) 성별 읽기
    if (in.read() == 1) 
      member.gender = true;
    else 
      member.gender = false;

    in.close();

    System.out.printf("%s\n", member);
  }
}






