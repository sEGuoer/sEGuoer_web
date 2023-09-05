package D20230904;


import D20230815.User;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidDemo {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        Connection connection = null;
        try (InputStream inputStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties")) {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }

    public List<User> testPreparedStatement() {
        String query = "select id, email, password, username, account from user";
        try (PreparedStatement ppstmt = dataSource.getConnection().prepareStatement(query);) {
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

    public User getUser( String email) {
        String query = "select id, email, password, username, account from user where email = ?";
        try (PreparedStatement ppstmt = dataSource.getConnection().prepareStatement(query)) {
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
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getUser_id(String email) {
        String query = "select id from user where email = ?";
        try (PreparedStatement ppstmt = dataSource.getConnection().prepareStatement(query)) {
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

    public int add(String email, String password, String account, boolean a) {
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
        if (!isExist && a) {
            try (PreparedStatement ppstmt = dataSource.getConnection().prepareStatement(insertSql)) {
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

    public void add_Operation_record( String email, String time, String operation) {
        String insertSql = "insert into operation_record(user_id, Time, operation ) values(?, ? ,?);";
        try (PreparedStatement ppstmt = dataSource.getConnection().prepareStatement(insertSql)) {
            ppstmt.setInt(1, getUser_id( email));
            ppstmt.setString(2, time);
            ppstmt.setString(3, operation);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete( String email) {
        PreparedStatement ppstmt = null;
        String updateSql = "delete from user where email = ?";
        try {
            ppstmt = dataSource.getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, email);
            ppstmt.executeUpdate();
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
    }

    public void update( String email, String account, String password, String updateEmail) {
        PreparedStatement ppstmt = null;
        String updateSql = "update user set email = ? , account = ? , password = ? where email = ?";
        try {
            ppstmt = dataSource.getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, email);
            ppstmt.setString(2, account);
            ppstmt.setString(3, password);
            ppstmt.setString(4, updateEmail);
            ppstmt.executeUpdate();
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
    }

    public void updateLoginTime( String email, String loginTime) {
        PreparedStatement ppstmt = null;
        String updateSql = "update user set loginTime = ? where email = ?";
        try {
            ppstmt = dataSource.getConnection().prepareStatement(updateSql);
            ppstmt.setString(1, loginTime);
            ppstmt.setString(2, email);
            ppstmt.executeUpdate();
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
    }

    public static void main(String[] args) {
        DruidDemo druidDemo = new DruidDemo();
        druidDemo.testPreparedStatement();
//        jdbcTest.getUser(connection, "admin@1");
//        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.add(connection);
//        jdbcTest.testPreparedStatement(connection);
    }
}