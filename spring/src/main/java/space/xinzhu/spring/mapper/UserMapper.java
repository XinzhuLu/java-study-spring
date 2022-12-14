package space.xinzhu.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import space.xinzhu.spring.pojo.Person;

import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Mapper
public interface UserMapper {
    @Select("select * from tb_user")
    List<Person> selectAll();
}
