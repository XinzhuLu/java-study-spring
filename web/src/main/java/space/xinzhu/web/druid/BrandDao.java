package space.xinzhu.web.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class BrandDao {

    /**
     * 查询所有品牌信息
     * @return
     */
    public List<Brand> selectAll() throws Exception {
        //1 从连接池工具类中获取连接对象
        //1.1 加载配置文件
        Properties properties=new Properties();
        //读取文件，得到inputStream输入流
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        //加载数据
        properties.load(is);
        //1.2 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //1.3 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();


        //2 定义SQL
        String sql="select * from tb_brand";
        //3 获取PreparedStatement对象，预编译SQL
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4 如果SQL用有？占位符，就设置参数
        //5 执行SQL，获取结果
        ResultSet rs = pstmt.executeQuery();
        //6 处理结果
        List<Brand> brands=new ArrayList<>();
        while (rs.next()){
            //6.1 获取每一行数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            //6.2 封装成Brand对象
            Brand brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            //6.3 保存到List集合中
            brands.add(brand);
        }
        //7 释放资源
        rs.close();
        pstmt.close();
        conn.close();
        //返回结果
        return brands;
    }
}
