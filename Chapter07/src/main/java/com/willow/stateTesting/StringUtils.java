package com.willow.stateTesting;

public class StringUtils {
    public String reverse(String s){
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }
}
