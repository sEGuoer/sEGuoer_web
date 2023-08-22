package D20230818;

import D20230815.User;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
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

    public List<User> testPreparedStatement(Connection connection) {
        String query = "select id, email, password, username, account from user";
        try (PreparedStatement ppstmt = connection.prepareStatement(query);) {
            List<User> list = new ArrayList<>();
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String account = rs.getString("account");
                User user = new User();
                user.setUser(username, email, password, account);
                list.add(user);
                System.out.println(id + "\t" + email + "\t" + password + "\t" + username + account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(Connection connection, String email) {
        String query = "select id, email, password, username, account from user where email = ?";
        try (PreparedStatement ppstmt = connection.prepareStatement(query)) {
            ppstmt.setString(1, email);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dataEmail = rs.getString("email");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String account = rs.getString("account");
                User user = new User();
                user.setUser(username, dataEmail, password, account);
                System.out.println(id + "\t" + dataEmail + "\t" + password + "\t" + username + account);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(Connection connection, String email, String password, String account) {
        String insertSql = "insert into user(email, password, username, account) values(?, ?, ? ,?);";
        User useri = getUser(connection, email);
        boolean isExist = false;
        int i = 0;
        if (useri == null){
        }else {
            isExist = true;
            if (useri.getAccount().equals(account)){
                i = 1;
            }else {
                i = 3;
            }
        }
        if (!isExist) {
            try (PreparedStatement ppstmt = connection.prepareStatement(insertSql)) {
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
    public String soutYourInfo(HttpServletResponse resp, String sout) throws IOException {
        resp.getWriter().write(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\"\n" +
                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>sEGuoer's_website</title>" +
                        "</head>\n" +
                        "<body>\n" +
                        "<p>" + sout + "</p>" +
                        "</body>\n" +
                        "</html>\n"
        );
        return sout;
    }

    public static void main(String[] args) {
        JDBCDemo jdbcTest = new JDBCDemo();
        Connection connection = jdbcTest.getConnection();
        jdbcTest.getUser(connection, "admin@1");
//        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.add(connection);
//        jdbcTest.testPreparedStatement(connection);
    }
}
