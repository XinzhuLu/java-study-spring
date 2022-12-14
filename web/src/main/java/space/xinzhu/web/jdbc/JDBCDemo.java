package space.xinzhu.web.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1 注册驱动，告诉程序使用哪个数据库
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接对象 Connection
        String url="jdbc:mysql://localhost:3306/db2";   //连接路径，表示连接哪个数据库
        String username="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url,username,password);
//3 获取执行SQL的执行者对象  PreparedStatement
        PreparedStatement ps1 = conn.prepareStatement("update account set money = money-500 where name='李四' ");
        PreparedStatement ps2 = conn.prepareStatement("update account set money = money+500 where name='张三' ");

        try {
            // ============开启事务==========
            conn.setAutoCommit(false);
            //4. 执行sql
            int count1 = ps1.executeUpdate();//受影响的行数
            //5. 处理结果
            System.out.println(count1);
            int i = 1/0;
            //4. 执行sql
            int count2 = ps2.executeUpdate();//受影响的行数
            //5. 处理结果
            System.out.println(count2);

            // ============提交事务==========
            //程序运行到此处，说明没有出现任何问题，则需求提交事务
            conn.commit();
        } catch (Exception e) {
            // ============回滚事务==========
            //程序在出现异常时会执行到这个地方，此时就需要回滚事务
            conn.rollback();
            e.printStackTrace();
        } finally {
            //6. 释放资源
            ps1.close();
            ps2.close();
            conn.close();
        }
    }

    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void testDML() throws  Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "update account set money = 3000 where id = 1";
        //4. 获取执行sql的对象 PreparedStatement
        PreparedStatement ps = conn.prepareStatement(sql);
        //5. 执行sql
        int count = ps.executeUpdate();//执行完DML语句，受影响的行数
        //6. 处理结果
        //System.out.println(count);
        if(count > 0){
            System.out.println("修改成功~");
        }else{
            System.out.println("修改失败~");
        }
        //7. 释放资源
        ps.close();
        conn.close();
    }

    /**
     * 动态传参
     * @param
     * @throws Exception
     */
    @Test
    public void DMLtest() throws Exception {
        //1 注册驱动，告诉程序使用哪个数据库
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接对象 Connection
        String url="jdbc:mysql://localhost:3306/db2?userSSL=false";
        String username="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url,username,password);
        //3 获取执行SQL的执行者对象  Statement
        String sql="update account set money = ? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //4 执行操作
        //4.1 设置两个?代替的参数
        ps.setDouble(1,3000.0);
        ps.setInt(2,1);
        //设置完成之后等价于update account set money = 3000.0 where id=1
        //4.2 执行操作
        int count = ps.executeUpdate();
        //5 处理结果
        System.out.println("影响的行数： " + count);
        //6 释放资源
        ps.close();
        conn.close();
    }


    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void testDDL() throws  Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "drop database db2";
        //4. 获取执行sql的对象 PreparedStatement
        PreparedStatement ps = conn.prepareStatement(sql);
        //5. 执行sql
        int count = ps.executeUpdate(sql);//执行完DDL语句，可能是0
        //6. 处理结果
        System.out.println(count);

        //7. 释放资源
        ps.close();
        conn.close();
    }

    /**
     * resuleSet示例
     * @throws Exception
     */
    @Test
    public void testResultSet() throws  Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "select * from account";
        //4. 获取PreparedStatement对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //5. 执行sql
        ResultSet rs = ps.executeQuery();
        //6. 处理结果， 遍历rs中的所有数据
        // 6.1 光标向下移动一行，并且判断当前行是否有数据

        // 创建集合
        List<Account> list = new ArrayList<>();
        Account account = null;

        while (rs.next()){

            //6.2 获取数据  getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            account = new Account();
            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            // 存入集合
            list.add(account);
        }

        //7. 释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
