package D20230904.mybatis.mapper;


import D20230904.mybatis.po.User;

public interface UserMapper {
    User selectUser(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
