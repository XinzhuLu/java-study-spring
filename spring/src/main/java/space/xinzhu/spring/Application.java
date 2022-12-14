package space.xinzhu.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@MapperScan("space.xinzhu.spring.mapper")
public class Application {

    public static void main(String[] args) throws Exception{
        //Application.run(Application.class, args);
        //1 返回值为Spring容器对象
        ConfigurableApplicationContext ac = SpringApplication.run(Application.class, args);
        //2 从Spring容器中获取DataSource连接池对象
        DataSource dataSource = ac.getBean(DataSource.class);
        //3 调用DataSource的getConnection()获取连接的方法
        Connection conn=dataSource.getConnection();
        System.out.println("conn = "+conn);
    }

}
