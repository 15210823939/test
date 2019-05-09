package com.example.demo.pojo;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-26 15:59
 **/
public class GoDown {

  private static int max = 100;
  private  int current = 30;

  public synchronized void product(int need){
    while (current+need>max){
      System.out.println(Thread.currentThread().getName()+"不需要生产");
      try {
        wait(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    current +=need;
    System.out.println(Thread.currentThread().getName()+"生产"+need+"剩余"+current);
    notifyAll();
  }

  public synchronized void consume(int consume){
    while (current<consume){
      System.out.println(Thread.currentThread().getName()+"不够不能消费");
      try {
        wait(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    current -=consume;
    System.out.println(Thread.currentThread().getName()+"消费"+consume+"剩余"+current);
    notifyAll();
  }

  public static void main(String[] args) {
    GoDown goDown = new GoDown();
    Product product = new Product(101,goDown,"product");
    Product product1 = new Product(5,goDown,"product1");
    Product product2 = new Product(50,goDown,"product2");
    Product product3 = new Product(50,goDown,"product3");
    Product product4 = new Product(50,goDown,"product4");
    Product product5 = new Product(50,goDown,"product5");

    Consumer consumer = new Consumer(30,goDown,"consumer");
    Consumer consumer2 = new Consumer(15,goDown,"consumer2");
    Consumer consumer3 = new Consumer(15,goDown,"consumer3");
    Consumer consumer4 = new Consumer(15,goDown,"consumer4");
    Consumer consumer5 = new Consumer(15,goDown,"consumer5");

    consumer.start();
    consumer2.start();
/*    consumer3.start();
    consumer4.start();
    consumer5.start();*/

    product.start();
    product1.start();
    /*product2.start();
    product3.start();
    product4.start();
    product5.start();*/
  }

}