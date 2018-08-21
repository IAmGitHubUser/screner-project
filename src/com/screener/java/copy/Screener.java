//this is how package name should be
package com.screener.java.copy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import model.CharastericsName;

public class Screener {
    public static void main(String[] args) {

        PrintFidelityHighRoaLowPe printPrintFidelity = new PrintFidelityHighRoaLowPe();

        // Array with data type = CharastericsName
        CharastericsName[] enumValues = {CharastericsName.PRICE};

        String[] finvizValues = {"price", "marketCap", "pb", "epsGrowthLastFiveYears", "dividendYield", "netProfitMargin", "pe", "returnOnAsset",
                                 "longTermDebtToEquity", "salesGrowthLastFiveYears", "returnOnEquity", "debtToEquity", "epsGrowthTtm", "espGrowthQtrOverQtr",
                                 "returnOnInvestment", "grossMargin", "salesGrowthQtrOverQtr", "currentRatio"};

        String[] betterThanIndustryAverageValues = {"returnOnEquityPercentile", "returnOnEquity", "grossMarginPercentile", "grossMargin", "pePercentileReverse",
                                                    "pe", "debtToCapitalPercentileReverse", "debtToCapital", "priceToSalesPercentileReverse", "priceToSales",
                                                    "priceToCashFlowPercentileReverse", "priceToCashFlow"};

        String[] aapl = {"aapl"};

        String[] allTicker = {"BPT", "EBAY", "EQM", "GILD", "NTES", "PVAC", "GLW", "BWEN", "YRD"};

        String[] finvizValuesTickers = {"GLW"};
        String[] highRoaLowPeTickers = {"BPT", "EBAY", "EQM", "GILD", "NTES", "PVAC", "YRD"};

        String[] fundamentalsTickers = {"BWEN"};

        String[] highRoaLowPEScreenResultTickers = {"ACIA", "ADES", "AEIS", "ALT", "APRI", "ARCH", "AZPN", "BIVV", "BTX", "CACQ", "CET", "CHKR", "CLBS", "CLCT",
                                                    "CNS", "CORT", "CRT", "DHIL", "DMLP", "DPZ", "EBAY", "EGRX", "EMF", "ERF", "FDS", "FIZZ", "FWP", "GAIA",
                                                    "GBL", "GDP", "GPP", "HK", "IESC", "KEM", "MACK", "MANH", "MARPS", "MASI", "MKTX", "MLP", "MNKD", "MO",
                                                    "MOMO", "MPO", "MSB", "MTR", "MVO", "NAVB", "NBLX", "NHTC", "NRT", "NSH", "NTIP", "NTRI", "NVO", "OPNT",
                                                    "OXLC", "PBT", "PDEX", "PK", "PLPM", "PMD", "PRTS", "SBR", "SCKT", "SD", "SDT", "SJT", "SNOA", "SPEX",
                                                    "SPGI", "SSNT", "SUPN", "TNH", "TPL", "TREX", "TXN", "UBNT", "UPL", "VRS", "WINA", "YRD"};

        populateSpreadSheet(fundamentalsTickers, enumValues, excludedTickers());

    }

    public static void populateSpreadSheet(String[] tickers, CharastericsName[] values, String[] excludeThese) {
        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        for (String string : excludeThese) {
            tickers = ArrayUtils.removeElement(tickers, string);
        }

        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/destinationFile.txt");

        // false - do not append, but overwrite
        try {
            FileUtils.writeStringToFile(destinationFile, "", "UTF-8", false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String ticker : tickers) {
            MyHashMap printFinviz2 = new MyHashMap(ticker);
            System.out.print(ticker + " " + formatDateTime + " ");

            try {
                FileUtils.writeStringToFile(destinationFile, ticker + " " + formatDateTime + " ", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (CharastericsName value : values) {
                System.out.print(printFinviz2.getValue(value) + " ");

                try {
                    FileUtils.writeStringToFile(destinationFile, printFinviz2.getValue(value) + " ", "UTF-8", true);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            System.out.println();

            try {
                FileUtils.writeStringToFile(destinationFile, "\n", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    

    public static CharastericsName[] betterThanIndustryAverageValuesArray() {
        CharastericsName[] fidelityBetterThanIndustryAverageValues = {CharastericsName.PRICE
//                                                                      , "pePercentileReverse", "priceToCashFlowPercentileReverse", "priceToSalesPercentileReverse",
//                                                            "priceToBookPercentileReverse", "grossMarginQtrPercentile", "grossMarginPercentile",
//                                                            "ebitdMarginPercentile", "profitMarginQtrPercentile", "operationMarginQtrPercentile",
//                                                            "operationMargingPercentile", "pretaxMargingPercentile", "revenueGrowthLastQtrPercentile",
//                                                            "revenueGrowthTtmPercentile", "revenueGrowthLastFiveYearsPercentile", "epsGrowthLastQtrPercentile",
//                                                            "epsGrowthTtmPercentile", "epsGrowthLastFiveYearsPercentile",
//                                                            "bookValueGrowthLastFiveYearsPercentile", "cashFlowGrowthLastFiveYearsPercentile",
//                                                            "returnOnSalesLastQtrPercentile", "returnOnSalesTtmPercentile", "returnOnEquityLastQtrPercentile",
//                                                            "returnOnEquityPercentile", "returnOnAssetsLastQtrPercentile", "returnOnAssetsPercentile",
//                                                            "returnOnInvestmentLastQtrPercentile", "returnOnInvestmentTtmPercentile",
//                                                            "longTermDebtToEquityLastQtrPercentileReverse", "longTermDebtToEquityTtmPercentileReverse",
//                                                            "longTermDebtToAssetsLastQtrPercentileReverse", "longTermDebtToAssetsTtmPercentileReverse",
//                                                            "longTermDebtToCapitalLastQtrPercentileReverse", "longTermDebtToCapitalTtmPercentileReverse",
//                                                            "debtToEquityQtrPercentileReverse", "debtToEquityTtmPercentileReverse", "currentRatioPercentile"
                                                            };
        return fidelityBetterThanIndustryAverageValues;
    }

    public static String[] fundamentalsValueArray() {
        String[] fundamentalValues = {"peg", "grossMarginPercentile", "grossMargin", "pePercentileReverse", "pe", "priceToSalesPercentileReverse",
                                      "priceToSales", "priceToBook", "priceToCashFlowPercentileReverse", "priceToCashFlow", "returnOnEquityPercentile",
                                      "returnOnEquity"};
        return fundamentalValues;
    }

    public static String[] growthValuesArray() {
        String[] growthValues = {"espGrowthQtrOverQtr", "epsGrowthTtm", "returnOnEquity", "revenueGrowthLastQrtrvsSameQrtrPriorYear", "revenueGrowthTtm"};
        return growthValues;
    }

    public static CharastericsName[] highRoaLowPeValuesArray() {
        CharastericsName[] highRoaLowPeValues = {CharastericsName.PE_PERCENTILE_REVERSE
//                                       , "pe", "returnOnAssetsPercentile", "returnOnAssetFromfidelity", "price"
                                       };
        return highRoaLowPeValues;
    }

    public static String[] excludedTickers() {
        // Excluded on Oct 5, 2017.
        String[] excludeThese = {"CACQ", "CET", "CHKR", "EMF", "MVO", "OXLC", "SDT", "MOG-A"};
        return excludeThese;

    }

}
