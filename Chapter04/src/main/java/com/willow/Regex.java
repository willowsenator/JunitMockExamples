package com.willow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public String getNumberList(String input) {
        String result = "";
        String splitArray[] = input.split(" ");
        Pattern pattern = Pattern.compile("\\d{3}");
        for(String splitString:splitArray){
            Matcher matcher  = pattern.matcher(splitString);

            if(matcher.find()){
                if(!result.isEmpty()){
                    result += ", ";
                }
                result += splitString.substring(matcher.start(), matcher.end());
            }
        }
        return result;
    }
}
