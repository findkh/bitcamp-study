//220124
package com.eomcs.openapi.json.jackson;
// JSON 문자열 --> 객체 : JSON 문자열을 해석하여 객체를 생성하기

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0120 {
  public static void main(String[] args) throws Exception {

    // 1) JSON 문자열 준비
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"1643027417327\"}";
    // 역슬래시 사용 이유 더블 쿼테이션 안에 더블 퀘이션을 문자로 인식하게 하기 위해 사용
    // 날짜에 밀리세컨드 값을 줘야 한다.

    // 2) JSON 처리 객체 준비
    ObjectMapper mapper = new ObjectMapper();

    // 3) JSON 문자열을 가지고 객체 만들기 
    Member m = mapper.readValue(jsonStr, Member.class);

    System.out.println(m);
  }
}





