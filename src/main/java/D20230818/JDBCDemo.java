package D20230818;

import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCDemo implements UserDAO {
    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", null);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to database");
        return conn;
    }

    public List<User> testPreparedStatement() {
        String query = "select id, email, password, username, account from user";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(query);) {
            List<User> list = new ArrayList<>();
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String account = rs.getString("account");
                User user = new User(username, email, password, account);
                list.add(user);
                System.out.println(id + "\t" + email + "\t" + password + "\t" + username + account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(String email) {
        String query = "select id, email, password, username, account from user where email = ?";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(query)) {
            ppstmt.setString(1, email);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dataEmail = rs.getString("email");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String account = rs.getString("account");
                User user = new User(username, dataEmail, password, account);
                System.out.println(id + "\t" + dataEmail + "\t" + password + "\t" + username + account);
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getUser_id(String email) {
        String query = "select id from user where email = ?";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(query)) {
            ppstmt.setString(1, email);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                return id;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
  public String getContent(int id) {
        String query = "select content from boke_table where id = ?";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(query)) {
            ppstmt.setInt(1, id);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                return content;
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int add(String email, String password, String account, boolean verifyCodeIsCorrect) {
        String insertSql = "insert into user(email, password, username, account) values(?, ?, ? ,?);";
        User useri = getUser(email);
        boolean isExist = false;
        int i = 0;
        if (useri == null) {
            if (password == "" || account == "") {
                isExist = true;
            }
        } else {
            isExist = true;
            if (useri.getAccount().equals(account)) {
                i = 1;
            } else if (password == "" || account == "") {
                i = 5;
            } else {
                i = 3;
            }
        }
        if (!isExist && verifyCodeIsCorrect) {
            try (PreparedStatement ppstmt = getConnection().prepareStatement(insertSql)) {
                ppstmt.setString(1, email);
                ppstmt.setString(2, password);
                ppstmt.setString(3, "person");
                ppstmt.setString(4, account);
                ppstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public int add_Operation_record(int id, String time, String operation) {
        String insertSql = "insert into operation_record (user_id, Time, operation ) values(?, ? ,?);";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(insertSql)) {
            ppstmt.setInt(1, id);
            ppstmt.setString(2, time);
            ppstmt.setString(3, operation);
            ppstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }



    public int delete(String email) {
        PreparedStatement ppstmt = null;
        String updateSql = "delete from user where email = ?";
        try {
            ppstmt = getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, email);
            ppstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int update(String email, String account, String password, String updateEmail) {
        PreparedStatement ppstmt = null;
        String updateSql = "update user set email = ? , account = ? , password = ? where email = ?";
        try {
            ppstmt = getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, email);
            ppstmt.setString(2, account);
            ppstmt.setString(3, password);
            ppstmt.setString(4, updateEmail);
            ppstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int updateLoginTime(String email, String loginTime) {
        PreparedStatement ppstmt = null;
        String updateSql = "update user set loginTime = ? where email = ?";
        try {
            ppstmt = getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, loginTime);
            ppstmt.setString(2, email);
            ppstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public User searchUser(String searchName) {
        String query = "select id, email, password, username, account from user where email LIKE ?";
        try (PreparedStatement ppstmt = getConnection().prepareStatement(query)) {
            ppstmt.setString(1, searchName);
            ResultSet rs = ppstmt.executeQuery();
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dataEmail = rs.getString("email");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String account = rs.getString("account");
                User user = new User(username, dataEmail, password, account);
                System.out.println(id + "\t" + dataEmail + "\t" + password + "\t" + username + account);
                userList.add(user);
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void DeleteManyUser(List<String> emailList) {
        for (String email : emailList) {
            delete(email);
        }
    }
    public void sentEmail(String verifyCode, String toWho) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1075534380@qq.com", "nsardjvomzokjbce");
            }
        });

        Message message = new MimeMessage(session);
        // who you are
        message.setFrom(new InternetAddress("1075534380@qq.com"));
        // send to ...
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toWho));

        message.setSubject("Mail Subject");

        String msg = "验证码为" + verifyCode + "\n" + "有效期为30分钟";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Sent message successfully....");
    }
    public static void main(String[] args) {
        JDBCDemo jdbcTest = new JDBCDemo();
        System.out.println(jdbcTest.getContent(1));
//        System.out.println(jdbcTest.searchUser("%709074535@qq.com%"));
//        Connection connection = jdbcTest.getConnection();
//        jdbcTest.getUser(connection, "admin@1");
//        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.add(connection);
//        jdbcTest.testPreparedStatement(connection);
    }
}
