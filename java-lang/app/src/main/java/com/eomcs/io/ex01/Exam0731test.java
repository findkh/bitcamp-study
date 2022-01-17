//220117
package com.eomcs.io.ex01;
//폴더명까지 포함해서 출력하기

import java.io.File;
import java.io.FileFilter;

public class Exam0731test {
  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, "");
  }


  static void printClasses(File dir, String packageName) {
    class JavaClassFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if ((pathname.isFile() || pathname.getName().endsWith(".class")) ||
            pathname.isDirectory()) {
          return true;
        }
        return false;
      }
    }

    File[] files = dir.listFiles(new JavaClassFilter()); 
    for (File f : files) {
      if (f.isFile()) {
        System.out.println(packageName + "." + f.getName().replace(".class", ""));
      } else {
        String subPackageName = packageName + (packageName.length() > 0 ? "." : "") + f.getName();        
        printClasses(f, subPackageName);
      }
    }
  }
}
