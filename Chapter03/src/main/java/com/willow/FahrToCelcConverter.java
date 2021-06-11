package com.willow;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FahrToCelcConverter {
    private FahrToCelcConverter(){

    }

    public static int toFahrenheit(int celsius){
        return celsius * 9 / 5 + 32;
    }

    public static int toCelcius(int fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }
}
