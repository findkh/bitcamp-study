//220117
package com.eomcs.io.ex01;
// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.

import java.io.File;

public class Exam0710_test {
  public static void main(String[] args) throws Exception {
    File dir = new File(".");
    System.out.println(dir.getCanonicalPath()); 
    //현재 폴더의 경로를 나타낸다

    printList(dir, 1);
  }


  static void printList(File dir, int level) {
    File[] files = dir.listFiles();

    //6. 출력문 메서드로 빼기
    for (File file : files) {
      printIndent(level);

      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName()); //폴더
        printList(file, level+1); 
      } else if (file.isFile()) {
        System.out.print("\\--");
        System.out.printf("%s\n", file.getName()); //파일
      }
    }
  }

  static void printIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
  }
}


