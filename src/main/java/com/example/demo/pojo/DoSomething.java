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

  int a = 0;

  @Override
  public  void run() {
    synchronized (this){
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName()+"something");
        a+=i;
      }
      notifyAll();
    }
  }



  public static void main(String[] args) {
    DoSomething d1 =  new DoSomething("张三");

    new Thread(new result(d1)).start();
    new Thread(new result(d1)).start();
    new Thread(new result(d1)).start();

    new Thread(d1).start();
  }
}

class result implements Runnable{
  DoSomething doSomething;

  public result(DoSomething doSomething) {
    this.doSomething = doSomething;
  }

  @Override
  public void run() {
    synchronized (doSomething){
      System.out.println(Thread.currentThread().getName()+"result");
      try {
        doSomething.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName()+doSomething.a);
    }
  }
}