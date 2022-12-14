package space.xinzhu.web.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import space.xinzhu.web.druid.Brand;

import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @Select：定义查询语句的注解，参数为SQL语句
     */
    @Select("select * from tb_user")
    List<User> selectAll();

    User selectById(int id);

    void add(User user);

    void update(User user);

    void deleteById(int id);

    //动态sql
    //List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    /**
     * 多条件查询-动态SQL
     * @return
     */
    @Select("<script>select * from tb_brand\n" +
            "        <where>\n" +
            "            <if test=\"status !=null\">\n" +
            "                status=#{status}\n" +
            "            </if>\n" +
            "            <if test=\"companyName!=null and companyName!=''\">\n" +
            "                and company_name like concat('%',#{companyName},'%')\n" +
            "            </if>\n" +
            "            <if test=\"brandName!=null and brandName!=''\">\n" +
            "                and brand_name like concat('%',#{brandName},'%')\n" +
            "            </if>\n" +
            "        </where></script>")
    List<Brand> selectByCondition(Brand brand);

}
