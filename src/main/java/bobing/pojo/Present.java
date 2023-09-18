package bobing.pojo;

public class Present {
   private String name;
   private int golden;
   private String content;

    @Override
    public String toString() {
        return '\'' + content + '\'' +"\n"
                + "奖励" + golden +  "人民币";
    }

    public int getGolden() {
        return golden;
    }

    public void setGolden(int golden) {
        this.golden = golden;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
