package screener;

import java.util.Arrays;

import com.screener.java.tickers.PositiveNumbers;

/**
 * 
 * @author hpatel
 *
 */
public class ReutersBetterThanIndustryAverageScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        PositiveNumbers companiesWithPositiveNumbers = new PositiveNumbers();

        Screener screener = new Screener();

        ReutersBetterThanIndustryAverageScreener reutersBetterThanIndustryAverageScreener = new ReutersBetterThanIndustryAverageScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(companiesWithPositiveNumbers.tickers()));

        String[] positiveCompaniesArray = companiesWithPositiveNumbers.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(positiveCompaniesArray, screener.reutersBetterThanIndustryAverageValuesArray(), screener.excludedTickers(),
                                     "fidelityBetterThanIndustryAverageScreener");

        reutersBetterThanIndustryAverageScreener.getScreenResult();
    }

}
