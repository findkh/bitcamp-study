package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class My1Controller {

  String[] items = new String[10];
  int size = 0;

  @RequestMapping("/item/list")
  public Object list() {
    String[] arr = new String[size];
    for (int i = 0; i < size; i++) {
      arr[i] = items[i];
    }
    return arr;
  }

  @RequestMapping("/item/add")
  public Object add(String itemcode, String itemname, String sellingprice, String client, String clientcallnum, String unitprice, String quantity) {
    String item = itemcode + "," + itemname + "," + sellingprice + "," + client + "," + clientcallnum + "," + unitprice + "," + quantity;

    items[size++] = item;
    return size;
  }

  @RequestMapping("/item/get")
  public Object get(String itemcode) {
    for (int i = 0; i <size; i++) {
      /*String item = items[i];
      String[] values = item.split(",");
      if (values[0].equals(itemcode)) {
        return items[i];
      }*/

      if (items[i].split(",")[0].equals(itemcode)) {
        return items[i];
      }
    }
    return "";
  }

  @RequestMapping("/item/update")
  public Object update(String itemcode, String itemname, String sellingprice, String client, String clientcallnum, String unitprice, String quantity) {
    String item = itemcode + "," + itemname + "," + sellingprice + "," + client + "," + clientcallnum + "," + unitprice + "," + quantity;
    for(int i = 0; i < size; i++) {
      if (items[i].split(",")[0].equals(itemcode)) {
        items[i] = item;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/item/delete")
  public Object delete(String itemcode) {
    for (int i = 0; i < size; i++) {
      if (items[i].split(",")[0].equals(itemcode)) {

        for (int j = i + 1; j < size; j++) {
          items[j - 1] = items[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}
