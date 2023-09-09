package D20230906;

import D20230904.mybatis.po.User;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public interface UserDAO {
    public List<User> testPreparedStatement();
    public User getUser(String email);
    public int getUser_id( String email);
    public int add( String email, String password, String account,boolean verifyCodeIsCorrect);
    public int add_Operation_record(int id, String time, String operation);
    public int delete(String email);
    public int update( String email, String account,String password,String updateEmail);
    public int updateLoginTime( String email, String loginTime);

    public default User searchUser(String searchName) {
        return null;
    }
    public default void sentEmail(String verifyCode, String toWho) throws MessagingException {
    }

}
