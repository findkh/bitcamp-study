package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement //애노테이션으로 트랜잭션을 제어할 수 있게 설정한다.
@RestController
@SpringBootApplication
public class App {

  //@Bean
  PlatformTransactionManager transactionManager(DataSource ds) {
    return new DataSourceTransactionManager(ds);
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

}
