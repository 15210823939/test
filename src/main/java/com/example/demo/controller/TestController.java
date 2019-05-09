package com.example.demo.controller;

import com.example.demo.pojo.Person;
import com.example.demo.repository.Personrepository;
import com.mobvoi.vw.common.integration.URLCommonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangm,  minzhang@vw-mobvoi.com
 * @create 2019-04-19 16:57
 **/
@RestController
public class TestController {

  @Autowired
  private Personrepository personrepository;

  @Autowired
  private URLCommonService urlCommonService;

  @RequestMapping("/test")
  public Person test(Person person){
    try {
      Thread.sleep(10000L);
    } catch (InterruptedException e) {

    }
    personrepository.save(person);
    return person;
  }

  @RequestMapping("/queryByName")
  public List<Person> queryByName(String name){
    urlCommonService.getForObject("http://127.0.0.2:8085/test",String.class);
    return personrepository.findByName(name);
  }
}