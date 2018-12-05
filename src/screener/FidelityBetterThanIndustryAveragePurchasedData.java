//package screener;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//
//public class FidelityBetterThanIndustryAveragePurchasedData {
//    private static double price;
//
//    private static double pePercentileReverse;
//
//    private static double priceToCashFlowPercentileReverse;
//
//    private static double priceToSalesPercentileReverse;
//
//    private static double priceToBookPercentileReverse;
//
//    private static double grossMarginQtrPercentile;
//
//    private static double grossMarginPercentile;
//
//    private static double ebitdMarginPercentile;
//
//    private static double profitMarginQtrPercentile;
//
//    private static double operationMarginQtrPercentile;
//
//    private static double operationMargingPercentile;
//
//    private static double pretaxMargingPercentile;
//
//    private static double revenueGrowthLastQtrPercentile;
//
//    private static double revenueGrowthTtmPercentile;
//
//    private static double revenueGrowthLastFiveYearsPercentile;
//
//    private static double epsGrowthLastQtrPercentile;
//
//    private static double epsGrowthTtmPercentile;
//
//    private static double epsGrowthLastFiveYearsPercentile;
//
//    private static double bookValueGrowthLastFiveYearsPercentile;
//
//    private static double cashFlowGrowthLastFiveYearsPercentile;
//
//    private static double returnOnSalesLastQtrPercentile;
//
//    private static double returnOnSalesTtmPercentile;
//
//    private static double returnOnEquityLastQtrPercentile;
//
//    private static double returnOnEquityPercentile;
//
//    private static double returnOnAssetsLastQtrPercentile;
//
//    private static double returnOnAssetsPercentile;
//
//    private static double returnOnInvestmentLastQtrPercentile;
//
//    private static double returnOnInvestmentTtmPercentile;
//
//    private static double longTermDebtToEquityLastQtrPercentileReverse;
//
//    private static double longTermDebtToEquityTtmPercentileReverse;
//
//    private static double longTermDebtToAssetsLastQtrPercentileReverse;
//
//    private static double longTermDebtToAssetsTtmPercentileReverse;
//
//    private static double longTermDebtToCapitalLastQtrPercentileReverse;
//
//    private static double longTermDebtToCapitalTtmPercentileReverse;
//
//    private static double debtToEquityQtrPercentileReverse;
//
//    private static double debtToEquityTtmPercentileReverse;
//
//    private static double currentRatioPercentile;
//
//    private static File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/fidelityBetterThanIndustryAveragePurchasedData.txt");
//
//    // public static void method(String ticker) throws IOException
//    FidelityBetterThanIndustryAveragePurchasedData(String ticker) throws IOException
//
//    {
//
//        List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");
//        for (String string : quoteListsFromFile) {
//            String[] quoteFromOneLineAtATime = string.split("\t");
////            System.out.println(Arrays.toString(quoteFromOneLineAtATime));
//            if (quoteFromOneLineAtATime[0].equalsIgnoreCase(ticker)) {
//                price = Double.parseDouble(quoteFromOneLineAtATime[2]);
//
//                // Valuation
//                // 1
//                pePercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[3]);
//                // 2
//                priceToCashFlowPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[4]);
//                // 3
//                priceToSalesPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[5]);
//                // 4
//                priceToBookPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[6]);
//
//                // Profit Margins
//
//                // +
//                grossMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[7]);
//                // 1
//                grossMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[8]);
//                // 2
//                ebitdMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[9]);
//                // +
//                profitMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[10]);
//                // +
//                operationMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[11]);
//                // 3
//                operationMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[12]);
//                // 4
//                pretaxMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[13]);
//
//                // Growth
//                // 1
//                revenueGrowthLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[14]);
//                // 2
//                revenueGrowthTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[15]);
//                // 3
//                revenueGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[16]);
//
//                // 4
//                epsGrowthLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[17]);
//                // 5
//                epsGrowthTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[18]);
//                // 6
//                epsGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[19]);
//                // 7
//                bookValueGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[20]);
//                // 8
//                cashFlowGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[21]);
//
//                // Returns
//                // 1
//                returnOnSalesLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[22]);
//                // 2
//                returnOnSalesTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[23]);
//                // 3
//                returnOnEquityLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[24]);
//                // 4
//                returnOnEquityPercentile = Double.parseDouble(quoteFromOneLineAtATime[25]);
//                // 5
//                returnOnAssetsLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[26]);
//                // 6
//                returnOnAssetsPercentile = Double.parseDouble(quoteFromOneLineAtATime[27]);
//                // 7
//                returnOnInvestmentLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[28]);
//                // 8
//                returnOnInvestmentTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[29]);
//
//                // Debts
//                // 1
//                longTermDebtToEquityLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[30]);
//                // 2
//                longTermDebtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[31]);
//                // 3
//                longTermDebtToAssetsLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[32]);
//                // 4
//                longTermDebtToAssetsTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[33]);
//                // 5
//                longTermDebtToCapitalLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[34]);
//                // 6
//                longTermDebtToCapitalTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[35]);
//                // 7
//                debtToEquityQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[36]);
//                // 8
//                debtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[37]);
//                // 9
//                currentRatioPercentile = Double.parseDouble(quoteFromOneLineAtATime[38]);
//
//            }
//        }
//
//    }
//
//    /**
//     * @return the price
//     */
//    public static double getPrice() {
//        return price;
//    }
//
//    /**
//     * @return the pePercentileReverse
//     */
//    public static double getPePercentileReverse() {
//        return pePercentileReverse;
//    }
//
//    /**
//     * @return the priceToCashFlowPercentileReverse
//     */
//    public static double getPriceToCashFlowPercentileReverse() {
//        return priceToCashFlowPercentileReverse;
//    }
//
//    /**
//     * @return the priceToSalesPercentileReverse
//     */
//    public static double getPriceToSalesPercentileReverse() {
//        return priceToSalesPercentileReverse;
//    }
//
//    /**
//     * @return the priceToBookPercentileReverse
//     */
//    public static double getPriceToBookPercentileReverse() {
//        return priceToBookPercentileReverse;
//    }
//
//    /**
//     * @return the grossMarginQtrPercentile
//     */
//    public double getGrossMarginQtrPercentile() {
//        return grossMarginQtrPercentile;
//    }
//
//    /**
//     * @return the grossMarginPercentile
//     */
//    public double getGrossMarginPercentile() {
//        return grossMarginPercentile;
//    }
//
//    /**
//     * @return the ebitdMarginPercentile
//     */
//    public double getEbitdMarginPercentile() {
//        return ebitdMarginPercentile;
//    }
//
//    /**
//     * @return the profitMarginQtrPercentile
//     */
//    public static double getProfitMarginQtrPercentile() {
//        return profitMarginQtrPercentile;
//    }
//
//    /**
//     * @return the operationMarginQtrPercentile
//     */
//    public double getOperationMarginQtrPercentile() {
//        return operationMarginQtrPercentile;
//    }
//
//    /**
//     * @return the operationMargingPercentile
//     */
//    public double getOperationMargingPercentile() {
//        return operationMargingPercentile;
//    }
//
//    /**
//     * @return the pretaxMargingPercentile
//     */
//    public static double getPretaxMargingPercentile() {
//        return pretaxMargingPercentile;
//    }
//
//    /**
//     * @return the revenueGrowthLastQtrPercentile
//     */
//    public static double getRevenueGrowthLastQtrPercentile() {
//        return revenueGrowthLastQtrPercentile;
//    }
//
//    /**
//     * @return the revenueGrowthTtmPercentile
//     */
//    public static double getRevenueGrowthTtmPercentile() {
//        return revenueGrowthTtmPercentile;
//    }
//
//    /**
//     * @return the revenueGrowthLastFiveYearsPercentile
//     */
//    public static double getRevenueGrowthLastFiveYearsPercentile() {
//        return revenueGrowthLastFiveYearsPercentile;
//    }
//
//    /**
//     * @return the epsGrowthLastQtrPercentile
//     */
//    public static double getEpsGrowthLastQtrPercentile() {
//        return epsGrowthLastQtrPercentile;
//    }
//
//    /**
//     * @return the epsGrowthTtmPercentile
//     */
//    public static double getEpsGrowthTtmPercentile() {
//        return epsGrowthTtmPercentile;
//    }
//
//    /**
//     * @return the epsGrowthLastFiveYearsPercentile
//     */
//    public static double getEpsGrowthLastFiveYearsPercentile() {
//        return epsGrowthLastFiveYearsPercentile;
//    }
//
//    /**
//     * @return the bookValueGrowthLastFiveYearsPercentile
//     */
//    public static double getBookValueGrowthLastFiveYearsPercentile() {
//        return bookValueGrowthLastFiveYearsPercentile;
//    }
//
//    /**
//     * @return the cashFlowGrowthLastFiveYearsPercentile
//     */
//    public static double getCashFlowGrowthLastFiveYearsPercentile() {
//        return cashFlowGrowthLastFiveYearsPercentile;
//    }
//
//    /**
//     * @return the returnOnSalesLastQtrPercentile
//     */
//    public static double getReturnOnSalesLastQtrPercentile() {
//        return returnOnSalesLastQtrPercentile;
//    }
//
//    /**
//     * @return the returnOnSalesTtmPercentile
//     */
//    public static double getReturnOnSalesTtmPercentile() {
//        return returnOnSalesTtmPercentile;
//    }
//
//    /**
//     * @return the returnOnEquityLastQtrPercentile
//     */
//    public static double getReturnOnEquityLastQtrPercentile() {
//        return returnOnEquityLastQtrPercentile;
//    }
//
//    /**
//     * @return the returnOnEquityPercentile
//     */
//    public static double getReturnOnEquityPercentile() {
//        return returnOnEquityPercentile;
//    }
//
//    /**
//     * @return the returnOnAssetsLastQtrPercentile
//     */
//    public static double getReturnOnAssetsLastQtrPercentile() {
//        return returnOnAssetsLastQtrPercentile;
//    }
//
//    /**
//     * @return the returnOnAssetsPercentile
//     */
//    public static double getReturnOnAssetsPercentile() {
//        return returnOnAssetsPercentile;
//    }
//
//    /**
//     * @return the returnOnInvestmentLastQtrPercentile
//     */
//    public static double getReturnOnInvestmentLastQtrPercentile() {
//        return returnOnInvestmentLastQtrPercentile;
//    }
//
//    /**
//     * @return the returnOnInvestmentTtmPercentile
//     */
//    public static double getReturnOnInvestmentTtmPercentile() {
//        return returnOnInvestmentTtmPercentile;
//    }
//
//    /**
//     * @return the longTermDebtToEquityLastQtrPercentileReverse
//     */
//    public double getLongTermDebtToEquityLastQtrPercentileReverse() {
//        return longTermDebtToEquityLastQtrPercentileReverse;
//    }
//
//    /**
//     * @return the longTermDebtToEquityTtmPercentileReverse
//     */
//    public double getLongTermDebtToEquityTtmPercentileReverse() {
//        return longTermDebtToEquityTtmPercentileReverse;
//    }
//
//    /**
//     * @return the longTermDebtToAssetsLastQtrPercentileReverse
//     */
//    public double getLongTermDebtToAssetsLastQtrPercentileReverse() {
//        return longTermDebtToAssetsLastQtrPercentileReverse;
//    }
//
//    /**
//     * @return the longTermDebtToAssetsTtmPercentileReverse
//     */
//    public double getLongTermDebtToAssetsTtmPercentileReverse() {
//        return longTermDebtToAssetsTtmPercentileReverse;
//    }
//
//    /**
//     * @return the longTermDebtToCapitalLastQtrPercentileReverse
//     */
//    public static double getLongTermDebtToCapitalLastQtrPercentileReverse() {
//        return longTermDebtToCapitalLastQtrPercentileReverse;
//    }
//
//    /**
//     * @return the longTermDebtToCapitalTtmPercentileReverse
//     */
//    public static double getLongTermDebtToCapitalTtmPercentileReverse() {
//        return longTermDebtToCapitalTtmPercentileReverse;
//    }
//
//    /**
//     * @return the debtToEquityQtrPercentileReverse
//     */
//    public double getDebtToEquityQtrPercentileReverse() {
//        return debtToEquityQtrPercentileReverse;
//    }
//
//    /**
//     * @return the debtToEquityTtmPercentileReverse
//     */
//    public double getDebtToEquityTtmPercentileReverse() {
//        return debtToEquityTtmPercentileReverse;
//    }
//
//    /**
//     * @return the currentRatioPercentile
//     */
//    public static double getCurrentRatioPercentile() {
//        return currentRatioPercentile;
//    }
//
//    /**
//     * @return the destinationFile
//     */
//    public static File getDestinationFile() {
//        return destinationFile;
//    }
//
//}
