package com.screener.java;

import java.util.Arrays;

import com.screener.java.tickers.PositiveNumbersGt25Roa;

public class HighRoaLowPEScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        PositiveNumbersGt25Roa roaGreatenThan25List = new PositiveNumbersGt25Roa();

        Screener screener = new Screener();

        HighRoaLowPeScreener highRoaLowPeScreener = new HighRoaLowPeScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(roaGreatenThan25List.tickers()));

        String[] roaGreatenThan25Array = roaGreatenThan25List.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(roaGreatenThan25Array, screener.highRoaLowPeValuesArray(), screener.excludedTickers(), "highRoaLowPeValuesScreener");

        highRoaLowPeScreener.getScreenResult();
    }

}
