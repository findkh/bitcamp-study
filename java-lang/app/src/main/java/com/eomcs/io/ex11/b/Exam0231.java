//220119
package com.eomcs.io.ex11.b;
// java.io.Serializable 처럼 사용되는 인터페이스 : java.lang.Cloneable 인터페이스

public class Exam0231 {

  static class Score /*java.lang.Object 수퍼 클래스를 지정하지 않으면 컴파일할 때 자동으로 붙음*/{
    String name;

    //복제 기능을 수행하려면 clone()을 오버라이딩 해야 한다.
    @Override 
    public Score clone() throws CloneNotSupportedException {
      // 1. private에서 public으로 변환 가능
      return (Score) super.clone();
      // 2. 리턴 타입을 서브타입으론 못바꾸지만 서브 타입으로 변환 가능하다.(형변환)
    }
  }

  public static void main(String[] args) throws Exception {

    Score obj = new Score();

    System.out.println(obj instanceof Cloneable);

    Score copy = obj.clone(); // 런타임(run-time) 오류!
    // Object에서 상속 받은 clone()을 호출하려면
    // 해당 클래스에 대해 복제 기능을 활성화해야 한다.
    // 방법? java.lang.Cloneable 인터페이스를 구현하라!
  }
}
