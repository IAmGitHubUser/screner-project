//package screener;
//
//import java.util.Arrays;
//
//import com.screener.java.tickers.PositiveNumbers;
//
///**
// * do this
// * 
// * @author hpatel
// *
// */
//public class FidelityBetterThanIndustryAverageScreenResult {
//    @SuppressWarnings("static-access")
//    public static void main(String[] args) {
//        PositiveNumbers companiesWithPositiveNumbers = new PositiveNumbers();
//
//        Screener screener = new Screener();
//
//        FidelityBetterThanIndustryAverageScreener fidelityBetterThanIndustryAverageScreener = new FidelityBetterThanIndustryAverageScreener();
//
//        // Get list of tickers in array
//        System.out.println(Arrays.toString(companiesWithPositiveNumbers.tickers()));
//
//        String[] positiveCompaniesArray = companiesWithPositiveNumbers.tickers();
//
//        // populate spreadsheet with tickers and value
//        screener.populateSpreadSheet(positiveCompaniesArray, screener.fidelityBetterThanIndustryAverageValuesArray(), screener.excludedTickers(),
//                                     "fidelityBetterThanIndustryAverageScreener");
//
//        fidelityBetterThanIndustryAverageScreener.getScreenResult();
//    }
//
//}
