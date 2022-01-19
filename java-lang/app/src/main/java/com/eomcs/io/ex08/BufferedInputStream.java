package com.eomcs.io.ex08;
//220119
import java.io.IOException;
import java.io.InputStream;

//판31)
public class BufferedInputStream { //상속 안받은 독립적인 클래스
  InputStream in; //다형적 변수의 특징. 자식까지 가리킬 수 있다. 
  //레퍼런스의 타입이 인터페이스나 추상 클래스라면 자식 클래스를 가리킨다. 
  //모든 InputStream을 가리킬 수 있다. 

  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  //생성자
  public BufferedInputStream(InputStream in) {
    this.in = in;
  }

  public int read() throws IOException {
    if (cursor == size) { // 버퍼에 저장되어 있는 데이터를 모두 읽었다는 의미
      if ((size = in.read(buf)) == -1) { // 파일에서 데이터를 읽으려 했는데 데이터가 없다.
        return -1;
      }
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff;
  }

  public int read(byte[] buf) throws IOException {
    int i = 0;
    for (; i < buf.length; i++) {
      // 1바이트를 읽어서 파라미터로 받은 바이트 배열에 채운다.
      int b = this.read();
      if (b == -1) {
        // 바이트 배열을 다 채우기도 전에 읽을 데이터가 없다면 읽기를 멈춘다.
        break;
      }
      buf[i] = (byte) b;
    }
    return i; // 지금까지 읽은 데이터의 수를 리턴한다.
  }

  public void close() throws IOException {
    in.close();
  }
}


