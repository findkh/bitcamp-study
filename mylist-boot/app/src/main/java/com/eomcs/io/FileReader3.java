package com.eomcs.io;

public class FileReader3 extends java.io.FileReader {

  //기본 생성자를 안만들면 컴파일러가 기본 생성자를 만든다.
  //  public FileReader3() {
  //    super();
  //  }
  //FileReader에 기본 생성자가 없다.
  //내가 기본 생성자를 만들어도 오류가 만들어진다.

  public FileReader3(String filename) throws Exception {
    super(filename);
  }

}
