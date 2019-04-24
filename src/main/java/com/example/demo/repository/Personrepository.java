package com.example.demo.repository;

import com.example.demo.pojo.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangm
 * @create 2019-04-19 16:51
 **/
@Repository
public interface Personrepository extends JpaRepository<Person, Long> {

  List<Person> findByName(String name);

}
