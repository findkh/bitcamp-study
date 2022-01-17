//220117
package com.eomcs.io.ex01;
// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
//Filefilter 사용

import java.io.File;
import java.io.FileFilter;

public class Exam0730x {
  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }

  //1. printClasses 메서드 만들기
  public static void printClasses(File dir) throws Exception {
    //    System.out.println(dir.getCanonicalPath());


    //3. accept 오버라이딩한다.
    class JavaClassFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isFile() && 
            pathname.getName().endsWith(".class") || 
            pathname.isDirectory() ) { //5. class를 포함한 디렉토리까지 리스트로 넘겨준다
          return true;
        }
        return false;
      }
    }

    //4. 만든 Filter 적용
    File[] files = dir.listFiles(new JavaClassFilter());
    for(File f : files) {
      if (f.isDirectory()) {//5. 디렉토리면 밑으로 내려가야 한다
        printClasses(f);
      } else {
        System.out.printf("%s\n", f.getName());
      }
    }
  }
} 




