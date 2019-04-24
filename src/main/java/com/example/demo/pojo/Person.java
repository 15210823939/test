package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-19 16:47
 **/
@Entity
@Data
public class Person {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private int age;

  public synchronized static void out() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      Thread.sleep(1000L);
      System.out.println(Thread.currentThread().getName()+"---"+i);
    }
  }
}