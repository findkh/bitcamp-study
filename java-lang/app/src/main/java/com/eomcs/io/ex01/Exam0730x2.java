//220117
package com.eomcs.io.ex01;
// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
//메서드로만 구현

import java.io.File;

public class Exam0730x2 {
  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }

  public static void printClasses(File dir){
    File[] files = dir.listFiles();
    for(File f : files) {
      if (f.isDirectory()) {
        printClasses(f);
      } else if (f.isFile() && f.getName().endsWith(".class")) {
        System.out.printf("%s\n", f.getName());
      }
    }
  }
} 




