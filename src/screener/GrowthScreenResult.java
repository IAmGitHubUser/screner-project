package screener;

import java.io.IOException;
import java.util.Arrays;

import com.screener.java.tickers.PositiveNumbersGt15RoaGt20EpsGrwthQtr;

public class GrowthScreenResult {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws IOException {
        PositiveNumbersGt15RoaGt20EpsGrwthQtr positiveNumbersGt15RoaGt20EpsGrwthQtr = new PositiveNumbersGt15RoaGt20EpsGrwthQtr();
        Screener screener = new Screener();
        GrowthScreener fidelityGrowthScreener = new GrowthScreener();

        // Get list of tickers in array
        System.out.println(Arrays.toString(positiveNumbersGt15RoaGt20EpsGrwthQtr.tickers()));
        String[] positiveNumbersGt15RoaGt20EpsGrwthQtrArray = positiveNumbersGt15RoaGt20EpsGrwthQtr.tickers();

        // populate spreadsheet with tickers and value
        screener.populateSpreadSheet(positiveNumbersGt15RoaGt20EpsGrwthQtrArray, screener.growthValuesArray(), screener.excludedTickers(),
                                     "fidelityGrowthTickersScreener");

        fidelityGrowthScreener.getScreenResult();
    }

}
