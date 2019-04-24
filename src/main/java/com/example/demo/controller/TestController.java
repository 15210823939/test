package com.example.demo.controller;

import com.example.demo.pojo.Person;
import com.example.demo.repository.Personrepository;
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

  @RequestMapping("/test")
  public Person test(Person person){
    personrepository.save(person);
    return person;
  }

  @RequestMapping("/queryByName")
  public List<Person> queryByName(String name){
    return personrepository.findByName(name);
  }
}