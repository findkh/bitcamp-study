package com.eomcs.io.ex01;
// 활용 - 지정한 폴더를 삭제하라.

import java.io.File;

public class Exam0720test  {
  public static void main(String[] args) throws Exception {

    //1. temp 디렉토리를 삭제하기
    File dir = new File("temp");
    //System.out.println(dir.getCanonicalPath());

    deleteFile(dir);
  }

  //2. 메서드 만들기
  static void deleteFile(File dir) {

    //4. 주어진 파일이 디렉토리라면 하위 파일이나 디렉토리를 찾아 지운다
    if (dir.isDirectory()) {
      File [] files = dir.listFiles();
      for (File file : files) {
        deleteFile(file);
      }
    }

    //3. 현재 파일이나 폴더 지우기
    dir.delete(); 
    // 디렉토리 밑에 디렉토리나 파일이 있으면 삭제되지 않는다.
  }
}


