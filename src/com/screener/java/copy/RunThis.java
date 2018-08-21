package com.screener.java.copy;

public class RunThis {
    
    public static void main(String[] args) {
        Quotes quotes = new Quotes();
        System.out.println(quotes.getCurrentRatio("AAPL"));
        
        String currentRatio = null;
        Quotes quotes2 = new Quotes("AAPL", currentRatio);
        System.out.println(quotes2.currentRatioString());
        
         
    }
    
    
}
