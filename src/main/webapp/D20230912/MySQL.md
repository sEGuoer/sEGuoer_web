

## MySQL语句

### (一)  创建

#### 1. 创建的命令为：create xxx filename

#### 如果不存在创建 create database if not exists db1;

#### comment为备注

其中xxx可以为数据库(database),表格(table)  
例如:
```mysql
create database db2;
create table tb_user
(
    age int comment '年龄'
) comment '用户表';
```

#### 2. 创建表格时加入的内容  create table tb_user

#### (名称 变量名 （两种Key） （自动生成，唯一的,是否为空） （comment） )

```mysql
create table tb_user
(
    id       int PRIMARY KEY auto_increment comment 'ID，唯一标识',
    username varchar(20) unique not null comment '用户名',
    age      int comment '年龄',
    gender   char(1) default '男' comment '性别'
) comment '用户表';  
```

### (二)  查看各种数据

询所有数据库 show databases  
查看当前数据库下的表 show tables  
查看指定表结构 DESCRIBE user  
查看数据库的建表语句 SHOW CREATE TABLE user

### (三) 修改表结构

1. 为表 tb_emp 添加字段 qq varchar(11):

```mysql
  ALTER TABLE tb_emp
    ADD (qq varchar(11));  
```

2. 修改 tb_emp 字段类型 qq varchar(13)

```mysql
 ALTER TABLE tb_emp
    MODIFY qq varchar(13);  
```

3. 修改 tb_emp 字段名 qq 为 qq_num varchar(13)  
```mysql
   ALTER TABLE tb_emp  
   CHANGE qq qq_num varchar(13);
```


4. 删除 tb_emp 的 qq_num 字段  
```mysql
  ALTER TABLE tb_emp  
   DROP COLUMN qq_num;
```
 

5. 将tb_emp 表名修改为 emp  
```mysql
   RENAME TABLE tb_emp TO emp;
```

6. 删除 tb_emp 表  
```mysql
   DROP TABLE tb_emp;
```


### (四) 数据操作语言

1. 为 tb_emp 表的 username, name, gender 字段插入值  
   INSERT into tb_emp(username, name , gender)  
   values ('二蛋', 'erdan', 10);
2. 为 tb_emp 表的 所有字段插入值  
   insert into tb_emp  
   values (null, 'ergouzi', '123', '二狗子', 2, '1.jpg', 1, '2010-01-01', now(), now());
3. 批量为 为 tb_emp 表的 username , name , gender 字段插入数据。一次插入两条记录  
   insert into tb_emp(username, name, gender)  
   values ('xiaoyang', '小样', 1),  
   ('pig', '二弟', 1);
4. 将 tb_emp 表的ID为1员工 姓名name字段更新为 '张三'  
   update tb_emp set name = '张三' , update_time = now() where id = 1;

5. 将 tb_emp 表的所有员工的入职日期更新为 '2010-01-01'  
   update tb_emp set entry_date = '2010-01-01', update_time = now();
6. 删除 tb_emp 表中 ID为1的员工  
   delete from tb_emp where id = 1;
7. 删除 tb_emp 表中的所有员工  
   delete from tb_emp;



