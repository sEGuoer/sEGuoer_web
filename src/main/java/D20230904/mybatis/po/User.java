package D20230904.mybatis.po;

public class User {
    public User(String username, String email, String password, String account) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.account = account;
    }

    private String username;
    private String email;
    private String password;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "{" +
                "\"account\":\"" + account + '\"' +
                ",\"email\":\"" + email + '\"' +
                ",\"password\":\"" + password + '\"' +
                ",\"exist\":\"true" + '\"' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String username, String email, String password,String account) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setAccount(account);
    }
}

