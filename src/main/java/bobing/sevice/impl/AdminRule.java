package bobing.sevice.impl;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;
import bobing.pojo.Present;
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
        for (int i = 0; i < list.size(); i++) {
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
        if (fourCount == 4 && oneCount == 1) {
            return "状元插金花";
        } else if (fourCount == 6) {
            return "六抔红";
        } else if (oneCount == 6 || twoCount == 6 || threeCount == 6 || fiveCount == 6 || sixCount == 6) {
            return "六抔黑";
        } else if (fourCount == 5) {
            return "五红";
        } else if (oneCount == 5 || twoCount == 5 || threeCount == 5 || fiveCount == 5 || sixCount == 5) {
            return "五子登科";
        } else if (fourCount == 4) {
            return "四红";
        } else if (oneCount == 1 && twoCount == 1 && threeCount == 1 && fourCount == 1 && fiveCount == 1 && sixCount == 1) {
            return "对堂";
        } else if (fourCount == 3) {
            return "三红";
        } else if (oneCount == 4 || twoCount == 4 || threeCount == 4 || fiveCount == 4 || sixCount == 4) {
            return "四进";
        } else if (fourCount == 2) {
            return "二举";
        } else if (fourCount == 1) {
            return "一秀";
        } else {
            return "啥也不是";
        }
    }

    @Override
    public Present getPrestent(String award) {
        Present present = new Present();
        switch (award) {
            case "状元插金花", "六抔红", "六抔黑", "五红", "五子登科", "四红" -> {
                present.setName("状元奖");
                present.setGolden(2000);
                present.setContent("恭喜你获得状元奖");
                return present;
            }
            case "对堂" -> {
                present.setName("榜眼奖");
                present.setGolden(1600);
                present.setContent("恭喜你获得榜眼奖");
                return present;
            }
            case "三红" -> {
                present.setName("探花奖");
                present.setGolden(1200);
                present.setContent("恭喜你获得探花奖");
                return present;
            }
            case "四进" -> {
                present.setName("进士奖");
                present.setGolden(1000);
                present.setContent("恭喜你获得进士奖");
                return present;
            }
            case "二举" -> {
                present.setName("举人奖");
                present.setGolden(800);
                present.setContent("恭喜你获得举人奖");
                return present;
            }
            case "一秀" -> {
                present.setName("秀才奖");
                present.setGolden(600);
                present.setContent("恭喜你获得秀才奖");
                return present;
            }
            case "啥也不是" -> {
                present.setName("秀才奖");
                present.setGolden(400);
                present.setContent("恭喜你获得秀才奖");
                return present;
            }
            default -> {
                present.setName("getPrestent出逻辑错误");
                return present;
            }
        }
    }
}
