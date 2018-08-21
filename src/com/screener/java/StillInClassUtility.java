package com.screener.java;

public class StillInClassUtility {
    public static void checkMin(String charasctisticName, Double value, Integer compareWith, String ticker) {
        if (value < compareWith) {
            System.out.println(charasctisticName + " is less than " + compareWith + " for " + ticker + " is " + value);
        }
    }
    
    public static void checkMax(String charasctisticName, Double value, Integer compareWith, String ticker) {
        if (value > compareWith) {
            System.out.println(charasctisticName + " is more than " + compareWith + " for " + ticker + " is " + value);
        }
    }

}
