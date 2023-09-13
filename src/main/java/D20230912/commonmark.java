package D20230912;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.parser.Parser;
import org.commonmark.node.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class commonmark {
    public static void main(String[] args) throws IOException {
        Parser parser = Parser.builder().build();
        String resource = "D20230912/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        D20230912.mybatis.mapper.UserMapper mapper = session.getMapper(D20230912.mybatis.mapper.UserMapper.class);
        Map map = new HashMap();
        map.put("title","MySQL");
        map.put("content","content");
        String input = mapper.searchBlog(map).get(0).getContent();
        Node document = parser.parse(input);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        System.out.println(renderer.render(document));  // "<p>This is <em>Sparta</em></p>\n"
    }
}
