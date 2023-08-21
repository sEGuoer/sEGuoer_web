package D20230818;

import D20230815.User;

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

    public int add(Connection connection, String email, String password, String account) {
        String insertSql = "insert into user(email, password, username, account) values(?, ?, ? ,?);";
        List<User> list = testPreparedStatement(connection);
        boolean isExist = false;
        int panduan = 0;
        for (User useri : list) {
            if (useri.getAccount().equals(account) && useri.getEmail().equals(email)) {
                isExist = true;
                panduan = 1;
                break;
            } else if (useri.getAccount().equals(account) && !useri.getEmail().equals(email)) {
                isExist = true;
                panduan = 2;
                break;
            } else if (useri.getEmail().equals(email) && !useri.getAccount().equals(account)) {
                isExist = true;
                panduan = 3;
                break;
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
        return panduan;
    }

    public static void main(String[] args) {
        JDBCDemo jdbcTest = new JDBCDemo();
        Connection connection = jdbcTest.getConnection();
        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.add(connection);
//        jdbcTest.testPreparedStatement(connection);
    }
}
