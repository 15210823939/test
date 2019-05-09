package com.example.demo;

import com.mobvoi.vw.common.integration.URLCommonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {


  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public URLCommonService urlCommonService(){
    return new URLCommonService();
  }
}
