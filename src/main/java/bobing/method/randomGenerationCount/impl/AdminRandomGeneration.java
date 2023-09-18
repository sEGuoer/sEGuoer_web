package bobing.method.randomGenerationCount.impl;

import bobing.method.randomGenerationCount.randomGenerationCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminRandomGeneration implements randomGenerationCount {
    @Override
    public List<String> getEveryCode() {
        String randomCode = randomGeneration();
        System.out.println(randomCode);
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i <randomCode.length() ; i++){
            list.add(String.valueOf(randomCode.charAt(i)));
        }
        return list;
    }

    @Override
    public String randomGeneration() {
        String mumber = "123456";
        String randomCode = "";
        Random random = new Random();
        for (int i = 0; i < 6 ; i++){
            int index = random.nextInt(mumber.length());
            char c = mumber.charAt(index);
            randomCode += c;
        }
        return randomCode;
    }
}
