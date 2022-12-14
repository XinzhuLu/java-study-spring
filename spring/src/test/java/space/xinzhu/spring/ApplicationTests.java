package space.xinzhu.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.xinzhu.spring.mapper.UserMapper;
import space.xinzhu.spring.pojo.Person;
import space.xinzhu.spring.service.AspectService;
import space.xinzhu.spring.service.LogService;

import java.util.List;
@Slf4j
@SpringBootTest
class ApplicationTests {


    @Autowired
    private AspectService personService;

    @Autowired
    private LogService logService;

    @Autowired
    private Person user;

    @Autowired
    private UserMapper userMapper; //注入需要的UserMapper对象
    @Test
    void testSelectAll() {
        //1 调用service的方法，查询所有
        List<Person> list = userMapper.selectAll();
        //2 遍历打印
        list.forEach(user -> System.out.println(user));
    }
    @Test
    void testYaml() {
        Person lisi = new Person(2, "lisi", "123");
        System.out.println("lisi = " + lisi);
        System.out.println(user);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void save() {
        personService.save(new Person(3, "李四"));
    }

    @Test
    public void update() {
        personService.update(new Person(3, "李小四"));
    }

    @Test
    public void delete() {
        personService.delete(1);
    }

    @Test
    public void findById() {
        Person person = logService.findById(1);
    }

    @Test
    public void findAll() {
        log.info("test@Log");
        List<Person> all = logService.findAll();
    }

    @Test
    public void findByPage() {
        List<Person> all = personService.findByPage(1, 5);
    }

}
