package com.example.demo.exception;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-22 11:05
 **/
public class MyException extends Exception {

  public MyException() {
  }

  public MyException(String message) {
    super(message);
  }

  public MyException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyException(Throwable cause) {
    super(cause);
  }

  public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public static void main(String[] args) {
    try {
      test();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void test() throws Exception {
    try {
      System.out.println("12");
      throw new MyException();
    } catch (Exception e) {
      throw e;
    }
  }
}