package com.screener.java.copy;

import java.util.Arrays;

public class FidelityBetterThanIndustryAverageScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        CompaniesWithPositiveNumbers companiesWithPositiveNumbers = new CompaniesWithPositiveNumbers();

        Screener screener = new Screener();

        FidelityBetterThanIndustryAverageScreener highRoaLowPeScreener = new FidelityBetterThanIndustryAverageScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(companiesWithPositiveNumbers.tickers()));

        String[] positiveCompaniesArray = companiesWithPositiveNumbers.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(positiveCompaniesArray, screener.betterThanIndustryAverageValuesArray(), screener.excludedTickers());

        highRoaLowPeScreener.getScreenResult();
    }

}
