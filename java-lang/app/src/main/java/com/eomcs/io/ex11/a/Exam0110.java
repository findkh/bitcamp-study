//220119
package com.eomcs.io.ex11.a;
// 인스턴스 입출력 - DataOutputStream으로 인스턴스 출력하기

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileOutputStream fileOut = new FileOutputStream("temp/member.data");
    DataOutputStream out = new DataOutputStream(fileOut);
    //우리가 만든 클래스들은 첫번째 바이트가 문자열의 바이트 개수를 의미
    //자바에서 제공해주는 write()는 첫 2byte가 바이트 개수를 의미한다.

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    out.writeUTF(member.name);
    out.writeInt(member.age);
    out.writeBoolean(member.gender);

    out.close();
    System.out.println("데이터 출력 완료!");
  }

}


