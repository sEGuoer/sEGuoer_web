package bobing.method.randomGenerationCount;

import java.util.ArrayList;
import java.util.List;

public interface randomGenerationCount {
    public default String randomGeneration(){return "";}
    public default List<String> getEveryCode(){
        List<String> list = new ArrayList<>();
        return list;}

}
