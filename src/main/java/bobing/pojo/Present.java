package bobing.pojo;

public class Present {
   private String name;
   private int golden;
   private String content;

    @Override
    public String toString() {
        return "Present{" +
                "name='" + name + '\'' +
                ", golden=" + golden +
                ", content='" + content + '\'' +
                '}';
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
