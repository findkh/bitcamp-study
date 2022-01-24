package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test2  {
  public static void main(String[] args) throws Exception {
    //String jsonStr = "[{\"name\":\"소보루\", \"maker\":\"안데르센\"}, {\"name\":\"단팥빵\", \"maker\":\"안데르센\"}]";
    //String jsonStr = "[{\"name\":\"소보루\", \"maker\":\"안데르센\"}]";
    String jsonStr = "[]";

    ObjectMapper mapper = new ObjectMapper();

    Bread[] arr = mapper.readValue(jsonStr, Bread[].class); //어떤 객체를 만들어야하는지 알려줘야 한다

    for (Bread obj : arr) {
      System.out.println(obj);
    }
  }
}
