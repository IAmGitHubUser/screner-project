package com.screener.java.copy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.CharastericsName;

public class MyHashMap {

    Finviz finviz = new Finviz();

    Fidelity fidelity = new Fidelity();

    private final Map<String, String> map;

    private Document doc = null;

    private Document docFidelity = null;

    public MyHashMap(String tickerSymbol) {
        map = new HashMap<>();
        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();
            docFidelity = Jsoup.connect("https://eresearch.fidelity.com/eresearch/evaluate/fundamentals/keyStatistics.jhtml?stockspage=keyStatistics&symbols="
                    + tickerSymbol).get();
            Elements bChildrerOfTd = doc.select("td > b");

            Elements percentileElement = docFidelity.select("td.right");
            Elements tickerElement = docFidelity.select("td.lft-rt-border");
            // System.out.println(tickerElement);
            // System.out.println(percentileElement);
            buildMap(bChildrerOfTd, percentileElement, tickerElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return map.get(key);
    }
    
    public String getValue(CharastericsName key) {
        return map.get(key);
    }

    private void buildMap(Elements elements, Elements percentileElement, Elements tickerElement) {

        map.put("bookValueGrowthLastFiveYearsPercentile", Fidelity.getPercentileElement(percentileElement, 63, false));
        map.put("cashFlowGrowthLastFiveYearsPercentile", Fidelity.getPercentileElement(percentileElement, 69, false));
        map.put("currentRatio", finviz.getCharacteristic(elements, 50, false));
        map.put("currentRatioPercentile", Fidelity.getPercentileElement(percentileElement, 150, false));
        map.put("epsGrowthLastFiveYears", finviz.getCharacteristic(elements, 39, true));
        map.put("epsGrowthThisYear", finviz.getCharacteristic(elements, 21, true));
        map.put("epsGrowthTtm", Fidelity.getTickerElements(tickerElement, 13));
        map.put("espGrowthQtrOverQtr", finviz.getCharacteristic(elements, 57, true));
        map.put("epsGrowthLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 36, false));
        map.put("epsGrowthTtmPercentile", Fidelity.getPercentileElement(percentileElement, 39, false));
        map.put("epsGrowthLastFiveYearsPercentile", Fidelity.getPercentileElement(percentileElement, 42, false));
        map.put("debtToCapital", Fidelity.getTickerElements(tickerElement, 47));
        // map.put("debtToCapitalPercentileReverse",
        // Fidelity.getPercentileElement(percentileElement, 141, true));
        map.put("debtToEquity", finviz.getCharacteristic(elements, 56, false));
        map.put("debtToEquityQtrPercentileReverse", Fidelity.getPercentileElement(percentileElement, 144, true));
        map.put("debtToEquityTtmPercentileReverse", Fidelity.getPercentileElement(percentileElement, 147, true));
        map.put("dividendYield", finviz.getCharacteristic(elements, 43, true));
        map.put("ebitdMarginPercentile", Fidelity.getPercentileElement(percentileElement, 84, false));
        map.put("grossMargin", finviz.getCharacteristic(elements, 46, true));
        map.put("grossMarginQtrPercentile", Fidelity.getPercentileElement(percentileElement, 78, false));
        map.put("grossMarginPercentile", Fidelity.getPercentileElement(percentileElement, 81, false));
        map.put("longTermDebtToAssetsLastQtrPercentileReverse", Fidelity.getPercentileElement(percentileElement, 132, true));
        map.put("longTermDebtToAssetsTtmPercentileReverse", Fidelity.getPercentileElement(percentileElement, 135, true));
        map.put("longTermDebtToCapitalLastQtrPercentileReverse", Fidelity.getPercentileElement(percentileElement, 138, true));
        map.put("longTermDebtToCapitalTtmPercentileReverse", Fidelity.getPercentileElement(percentileElement, 141, true));
        map.put("longTermDebtToEquity", finviz.getCharacteristic(elements, 62, false));
        map.put("longTermDebtToEquityLastQtrPercentileReverse", Fidelity.getPercentileElement(percentileElement, 126, true));
        map.put("longTermDebtToEquityTtmPercentileReverse", Fidelity.getPercentileElement(percentileElement, 129, true));
        map.put("marketCap", finviz.getCharacteristic(elements, 7, true));
        map.put("netProfitMargin", finviz.getCharacteristic(elements, 58, true));
        map.put("operationMarginQtrPercentile", Fidelity.getPercentileElement(percentileElement, 90, false));
        map.put("operationMargingPercentile", Fidelity.getPercentileElement(percentileElement, 93, false));
        map.put("pb", finviz.getCharacteristic(elements, 26, false));
        map.put("pe", finviz.getCharacteristic(elements, 2, false));
        map.put("pePercentileReverse", Fidelity.getPercentileElement(percentileElement, 6, true));
        map.put("peg", finviz.getCharacteristic(elements, 14, false));
        map.put("pretaxMargingPercentile", Fidelity.getPercentileElement(percentileElement, 99, false));
        map.put("price", finviz.getCharacteristic(elements, 66, false));
        map.put("priceToBook", Fidelity.getTickerElements(tickerElement, 10));
        map.put("priceToBookPercentileReverse", Fidelity.getPercentileElement(percentileElement, 30, true));
        map.put("priceToCashFlow", Fidelity.getTickerElements(tickerElement, 7));
        map.put("priceToCashFlowPercentileReverse", Fidelity.getPercentileElement(percentileElement, 21, true));
        map.put("priceToSales", Fidelity.getTickerElements(tickerElement, 9));
        map.put("priceToSalesPercentileReverse", Fidelity.getPercentileElement(percentileElement, 27, true));
        map.put("profitMarginQtrPercentile", Fidelity.getPercentileElement(percentileElement, 87, false));
        map.put("returnOnAsset", finviz.getCharacteristic(elements, 28, true));
        map.put("returnOnAssetFromfidelity", Fidelity.getTickerElements(tickerElement, 39));
        map.put("returnOnAssetsLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 114, false));
        map.put("returnOnAssetsPercentile", Fidelity.getPercentileElement(percentileElement, 117, false));
        map.put("returnOnEquity", finviz.getCharacteristic(elements, 34, true));
        map.put("returnOnEquityLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 108, false));
        map.put("returnOnEquityPercentile", Fidelity.getPercentileElement(percentileElement, 111, false));
        map.put("returnOnInvestmentLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 120, false));
        map.put("returnOnInvestmentTtmPercentile", Fidelity.getPercentileElement(percentileElement, 123, false));
        map.put("returnOnInvestment", finviz.getCharacteristic(elements, 40, true));
        map.put("returnOnSalesLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 102, false));
        map.put("returnOnSalesTtmPercentile", Fidelity.getPercentileElement(percentileElement, 105, false));
        map.put("revenueGrowthLastQtrPercentile", Fidelity.getPercentileElement(percentileElement, 51, false));
        map.put("revenueGrowthTtmPercentile", Fidelity.getPercentileElement(percentileElement, 54, false));
        map.put("revenueGrowthLastFiveYearsPercentile", Fidelity.getPercentileElement(percentileElement, 57, false));
        map.put("revenueGrowthLastQrtrvsSameQrtrPriorYear", Fidelity.getTickerElements(tickerElement, 17));
        map.put("revenueGrowthTtm", Fidelity.getTickerElements(tickerElement, 18));
        map.put("salesGrowthLastFiveYears", finviz.getCharacteristic(elements, 45, true));
        map.put("salesGrowthQtrOverQtr", finviz.getCharacteristic(elements, 51, true));
        // System.out.println(map);

    }

}
