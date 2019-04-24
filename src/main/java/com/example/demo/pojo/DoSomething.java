package com.example.demo.pojo;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-22 17:32
 **/
public class DoSomething implements Runnable {

  private String name;

  public DoSomething(String name) {
    this.name = name;
  }

  @Override
  public  void run() {
    try {
      Person.out();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    DoSomething d1 =  new DoSomething("张三");
    DoSomething d2 =  new DoSomething("李四");

    Thread thread = new Thread(d1);
    Thread thread2 = new Thread(d2);

    thread.start();
    thread2.start();
  }
}