package com.willow;

import java.util.ArrayList;

public class Exercise_3_11_3 {
    private Exercise_3_11_3(){

    }

    public static String reverse(String s){
        var tempArray = new ArrayList<String>(s.length());

        for(int i = 0; i < s.length(); i++){
            tempArray.add(s.substring(i, i+1));
        }

        StringBuilder reversedString = new StringBuilder(s.length());
        for(int i = tempArray.size() - 1; i >=0; i--){
            reversedString.append(tempArray.get(i));
        }

        return reversedString.toString();
    }
}
