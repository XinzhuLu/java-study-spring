-- 删除tb_account表
drop table if exists tb_account;
-- 创建tb_account表
create table tb_account
(
    id int primary key auto_increment, -- 账户id,主键自增
    name varchar(20) not null, -- 账户名称
    amount double not null -- 金额
);