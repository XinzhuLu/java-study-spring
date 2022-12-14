package space.xinzhu.spring.service;

import space.xinzhu.spring.pojo.Person;

import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public interface LogService {
    void save(Person person);

    void update(Person person);

    void delete(int id);

    List<Person> findAll();

    List<Person> findByPage(int page, int size);

    Person findById(int id);
}
