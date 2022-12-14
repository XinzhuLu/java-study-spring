package space.xinzhu.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
//@ConfigurationProperties(prefix = "spring.datasource")
@Configuration //表示该类是一个配置类，有SpringBoot自动扫描加载
public class DataSourceConfig {

/*    @Value("${druid.driverClassName}")
    private String driverClassName;

    @Value("${druid.url}")
    private String url;

    @Value("${druid.username}")
    private String username;

    @Value("${druid.password}")
    private String password;*/


    //private String url;

    //private String username;

    //private String password;

    // 配置文件中是driver-class-name, 转驼峰命名便可以绑定成
    //private String driverClassName;

    @Bean //默认添加到spring容器中Bean的名称就是方法名(首字母小写)
    public DruidDataSource dataSource(){
        //1 创建连接池对象
        DruidDataSource dataSource=new DruidDataSource();
        //2 设置连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //3 返回连接池对象，保存到Spring容器中
        return dataSource;

    }


}
