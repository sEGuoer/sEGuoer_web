package bobing.sevice;

import bobing.pojo.Present;

import java.util.List;

public interface BoBing {
    public default String getDiceCount(List<String> list){return "";}

    public default Present getPrestent(String award){return null;};
}
