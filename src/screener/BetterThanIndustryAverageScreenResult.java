package screener;

import java.util.Arrays;

public class BetterThanIndustryAverageScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        PositiveCompanies positiveCompanies = new PositiveCompanies();

        Screener screener = new Screener();

        BetterThanIndustryAverageScreener highRoaLowPeScreener = new BetterThanIndustryAverageScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(positiveCompanies.tickers()));

        String[] positiveCompaniesArray = positiveCompanies.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(positiveCompaniesArray, screener.betterThanIndustryAverageValuesArray(), screener.excludedTickers());

        highRoaLowPeScreener.getScreenResult();
    }

}
