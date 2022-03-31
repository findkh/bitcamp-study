package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Board {
  int no;
  String title;
  String content;
  int viewCount;
  Date createdDate;
  Member writer;
}
