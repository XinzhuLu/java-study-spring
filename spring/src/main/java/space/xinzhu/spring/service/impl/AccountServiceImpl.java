package space.xinzhu.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.xinzhu.spring.mapper.AccountDao;
import space.xinzhu.spring.service.AccountService;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    // 方法1：转账。要求：余额足够，才允许从 from 账户转账至 to 账户，转账金额为 amount
    public void transfer(int from, int to, int amount) {
        try {
            int fromBalance = accountDao.findBalanceBy(from);

            if (fromBalance - amount >= 0) {
                accountDao.update(from, -1 * amount);

                int i = 1/0;

                accountDao.update(to, amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 方法2：查询某个账户余额
    public int findBalance(int accountNo) {
        return accountDao.findBalanceBy(accountNo);
    }

/*
propagation   | 传播行为
Propagation.REQUIRED需要事务，有则加入，无则创建新事务
isolation     | 隔离级别
timeout       | 超时时间当规定时间内，事务仍未完成时，会回滚并结束事务 |
readOnly      | 是否只读某些数据库驱动会对只读事务做优化
rollbackFor   | 遇到什么异常回滚事务
noRollbackFor | 遇到什么异常不回滚事务
*/
    @Transactional(rollbackFor = Exception.class)
    public void transferT(int from, int to, int amount) {
        int fromBalance = accountDao.findBalanceBy(from);
        if (fromBalance - amount >= 0) {
            accountDao.update(from, -1 * amount);

            int i = 1/0;

            accountDao.update(to, amount);
        }
    }
}
