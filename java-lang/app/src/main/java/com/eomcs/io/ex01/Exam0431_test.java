//220117
package com.eomcs.io.ex01;
// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.

import java.io.File;

public class Exam0431_test {
  public static void main(String[] args) throws Exception {

    //1. 생성할 피일의 경로 설정
    File file = new File("temp/b/test2.txt");

    //    File file2 = new File("temp/a/test3.txt");

    //2. 파일을 생성하기 전에 존재하지 않는 폴더를 생성하기
    //    String path = file.getParent();
    //    File dir = new File(path);
    //    System.out.println(dir); //temp\b

    File dir = file.getParentFile();
    System.out.println(dir.getCanonicalPath());

    //    File dir2 = file2.getParentFile();
    //    System.out.println(dir2.getCanonicalPath());

    //3. 디렉토리를 생성한다.
    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성했습니다");
    } else {
      System.out.println("디렉토리를 생성할 수 없습니다");
    }

    //4. 파일을 생성한다.
    if (file.createNewFile()) {
      System.out.println("파일을 생성했습니다");
    } else {
      System.out.println("파일을 생성할 수 없습니다");
    }
  }
}
