package space.xinzhu.web.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class DruidDemo {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3. 加载配置文件
        Properties properties=new Properties();
        //读取文件，得到inputStream输入流
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        //加载数据
        properties.load(is);
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection); //获取到了连接后就可以继续做其他操作了

    }
}
