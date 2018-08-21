package com.screener.java.copy;

import java.util.Arrays;

public class HighRoaLowPEScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        RoaGreatenThan25List roaGreatenThan25List = new RoaGreatenThan25List();

        Screener screener = new Screener();

        HighRoaLowPeScreener highRoaLowPeScreener = new HighRoaLowPeScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(roaGreatenThan25List.tickers()));

        String[] roaGreatenThan25Array = roaGreatenThan25List.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(roaGreatenThan25Array, screener.highRoaLowPeValuesArray(), screener.excludedTickers());

        highRoaLowPeScreener.getScreenResult();
    }

}
