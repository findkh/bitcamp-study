//220117
package com.eomcs.io.ex01;
// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) throws Exception {

    // 현재 폴더의 정보를 알아낸다.
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리 이름을 알아내기
    //list는 직계 자식을 문자열로 배열에 담아서 출력한다.(디렉토리/파일 구분 안함)
    String[] names = dir.list();

    for (String name : names) {
      System.out.println(name);
    }
  }
}


