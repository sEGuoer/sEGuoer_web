package bobing.sevice.impl;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;
import bobing.sevice.BoBing;

import java.util.List;

public class AdminRule implements BoBing {
    @Override
    public String getDiceCount(List<String> list) {
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;
        for (int i = 0 ; i < list.size() ; i++){
            String everyCount = list.get(i);
            switch (everyCount) {
                case "1" -> oneCount++;
                case "2" -> twoCount++;
                case "3" -> threeCount++;
                case "4" -> fourCount++;
                case "5" -> fiveCount++;
                case "6" -> sixCount++;
            }
        }
        if (fourCount == 4 && oneCount == 1){
            return "状元插金花";
        }else if (fourCount == 6){
            return "六抔红";
        }else if (oneCount == 6 || twoCount == 6 || threeCount == 6 || fiveCount == 6 || sixCount == 6  ){
            return "六抔黑";
        }else if (fourCount == 5 ){
            return "五红";
        }else if (oneCount == 5 || twoCount == 5 || threeCount == 5 || fiveCount == 5 || sixCount == 5  ){
            return "五子登科";
        }else if (fourCount == 4 ){
            return "四红";
        }else if (oneCount == 1 && twoCount == 1 && threeCount == 1 && fourCount == 1 && fiveCount == 1 && sixCount == 1){
            return "对堂";
        }else if (fourCount == 3 ){
            return "三红";
        }else if (oneCount == 4 || twoCount == 4 || threeCount == 4 || fiveCount == 4 || sixCount == 4  ){
            return "四进";
        }else if (fourCount == 2 ){
            return "二举";
        }else if (fourCount == 1 ){
            return "一秀";
        }else {
            return "啥也不是";
        }
    }
}
