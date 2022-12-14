package space.xinzhu.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import space.xinzhu.spring.aspect.Log;
import space.xinzhu.spring.pojo.Person;
import space.xinzhu.spring.service.AspectService;
import space.xinzhu.spring.service.LogService;

import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Service
public class LogServiceImpl implements LogService {

    private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);

    @Log("testLog")
    @Override
    public void save(Person person) {
        long start = System.nanoTime();
        log.info("save({})", person);
        long end = System.nanoTime();
        log.info("cost time: {} ns", (end - start));
    }

    @Log("testLog")
    @Override
    public void update(Person person) {
        long start = System.nanoTime();
        log.info("update({})", person);
        long end = System.nanoTime();
        log.info("cost time: {} ns", (end - start));
    }

    @Log("testLog")
    @Override
    public void delete(int id) {
        log.info("service is doing delete()");
    }

    @Log("log.value---findAll()")
    @Override
    public List<Person> findAll() {

        log.info("service is doing findAll()");
        System.out.println("findAll()");
        return null;
    }

    @Log("log.value---findAll()")
    @Override
    public List<Person> findByPage(int page, int size) {
        return null;
    }

    @Log("testLog")
    @Override
    public Person findById(int id) {
        return null;
    }

    // ...
}
