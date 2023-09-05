package D20230904.mybatis.po;

public class operation_record {
    private int user_id;
    private String time;
    private String operation;

    @Override
    public String toString() {
        return "operation_record{" +
                "user_id=" + user_id +
                ", time='" + time + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    public operation_record(int user_id, String time, String operation) {
        this.user_id = user_id;
        this.time = time;
        this.operation = operation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
