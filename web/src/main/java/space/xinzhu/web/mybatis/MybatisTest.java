package space.xinzhu.web.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import space.xinzhu.web.druid.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1 加载核心配置文件，获取 SqlSessionFactory对象,mybatis官网复制即可
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口代理对象。
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4 执行方法，获取结果
        List<User> list = userMapper.selectAll();
        //5 处理结果，释放资源
        list.forEach(user -> System.out.println(user));
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置自动提交事务，这种情况不需要手动提交事务了
        //3. 获取Mapper接口的代理对象
        UserMapper brandMapper = sqlSession.getMapper(UserMapper.class);
        //准备参数对象，开发中由页面传递过来
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setCompanyName("波导手机");
        brand.setBrandName("波导");
        brand.setDescription("手机中的战斗机");
        brand.setOrdered(100);
        //4. 执行方法
        //brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }
}
