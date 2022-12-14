package space.xinzhu.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Mapper
public interface AccountDao {
    // 方法1：更新某个账户余额，传入的余额参数是正数表示增加、是负数表示减少
    @Update("update account set balance=balance+#{balance} where accountNo=#{accountNo}")
    void update(@Param("accountNo") int accountNo, @Param("balance") int balance);

    // 方法2：查询某个账户余额
    @Select("select balance from account where accountNo=#{accountNo}")
    int findBalanceBy(int accountNo);

}
