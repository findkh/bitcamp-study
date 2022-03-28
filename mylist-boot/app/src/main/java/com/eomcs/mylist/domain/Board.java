package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Board {
  int no;
  String title;
  String content;
  int viewCount;
  Date createdDate;
}
