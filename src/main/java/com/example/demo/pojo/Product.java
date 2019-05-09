package com.example.demo.pojo;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-26 16:09
 **/
public class Product extends Thread{

  private int size;
  private GoDown goDown;

  public Product(int size, GoDown goDown,String name) {
    this.size = size;
    this.goDown = goDown;
    super.setName(name);
  }

  @Override
  public void run() {
    goDown.product(size);
  }
}

class Consumer extends Thread{

  private int size;
  private GoDown goDown;

  public Consumer(int size, GoDown goDown, String name) {
    this.size = size;
    this.goDown = goDown;
    super.setName(name);

  }

  @Override
  public void run() {
    goDown.consume(size);
  }
}