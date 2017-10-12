package screener;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Quotes {
    Finviz finviz = new Finviz();
    private Document doc = null;
    private Document docFidelity = null;
    private String tickerSymbol;
    private Elements elements;

    
    private String currentRatio;
    private double epsGrowthLastFiveYears;
    private double epsGrowthThisYear;
    private double epsGrowthTtm;
    private double espGrowthQtrOverQtr;
    private double debtToCapital;
    private double debtToCapitalPercentileReverse;
    private double debtToEquity;
    private double dividendYield;
    private double grossMargin;
    private double grossMarginPercentile;
    private double longTermDebtToEquity;
    private double marketCap;
    private double netProfitMargin;
    private double pb;
    private double pe;
    private double pePercentileReverse;
    private double peg;
    private double price;
    private double priceToBook;
    private double priceToBookPercentileReverse;
    private double priceToCashFlow;
    private double priceToCashFlowPercentileReverse;
    private double priceToSales;
    private double priceToSalesPercentileReverse;
    private double returnOnAsset;
    private double returnOnAssetsPercentile;
    private double returnOnEquity;
    private double returnOnEquityPercentile;
    private double returnOnInvestment;
    private double RevenueGrowthLastQrtrvsSameQrtrPriorYear;
    private double RevenueGrowthTtm;
    private double salesGrowthLastFiveYears;
    private double salesGrowthQtrOverQtr;
    
    public Quotes(){
        System.out.println();
    }
    
    
    
    public void getDataFromWeb(String tickerSymbol) {
        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();
            docFidelity = Jsoup.connect("https://eresearch.fidelity.com/eresearch/evaluate/fundamentals/keyStatistics.jhtml?stockspage=keyStatistics&symbols="
                    + tickerSymbol).get();
            elements = doc.select("td > b");

            Elements percentileElement = docFidelity.select("td.right");
            Elements tickerElement = docFidelity.select("td.lft-rt-border");
            // System.out.println(tickerElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Quotes( String ticker, String currentRatio){
        this.currentRatio = currentRatio;
        getDataFromWeb(tickerSymbol);
        finviz.getCharacteristic(elements, 50, false);
    }
    
    public String getCurrentRatio(String tickerSymbol) {
        getDataFromWeb(tickerSymbol);
        return finviz.getCharacteristic(elements, 50, false);
    }
    
    public String currentRatioString() {
        return currentRatio;
    }
    
    
    
//    currentRatio = finviz.getCharacteristic(elements,50,false);
//    
//    epsGrowthLastFiveYears=finviz.getCharacteristic(elements,39,true);
//    epsGrowthThisYear=finviz.getCharacteristic(elements,21,true);
//    epsGrowthTtm=Fidelity.getTickerElements(tickerElement,13);
//    espGrowthQtrOverQtr=finviz.getCharacteristic(elements,57,true);
//    debtToCapital=Fidelity.getTickerElements(tickerElement,47);
//    debtToCapitalPercentileReverse=Fidelity.getPercentileElement(percentileElement,141,true);
//    debtToEquity=finviz.getCharacteristic(elements,56,false);
//    dividendYield=finviz.getCharacteristic(elements,43,true);
//    grossMargin=finviz.getCharacteristic(elements,46,true);
//    grossMarginPercentile=Fidelity.getPercentileElement(percentileElement,81,false);
//    longTermDebtToEquity=finviz.getCharacteristic(elements,62,false);
//    marketCap=finviz.getCharacteristic(elements,7,true);
//    netProfitMargin=finviz.getCharacteristic(elements,58,true);
//    pb=finviz.getCharacteristic(elements,26,false);
//    pe=finviz.getCharacteristic(elements,2,false);
//    pePercentileReverse=Fidelity.getPercentileElement(percentileElement,6,true);
//    peg=finviz.getCharacteristic(elements,14,false);
//    price=finviz.getCharacteristic(elements,66,false);
//    priceToBook=Fidelity.getTickerElements(tickerElement,10);
//    priceToBookPercentileReverse=Fidelity.getPercentileElement(percentileElement,30,true);
//    priceToCashFlow=Fidelity.getTickerElements(tickerElement,7);
//    priceToCashFlowPercentileReverse=Fidelity.getPercentileElement(percentileElement,21,true);
//    priceToSales=Fidelity.getTickerElements(tickerElement,9);
//    priceToSalesPercentileReverse=Fidelity.getPercentileElement(percentileElement,27,true);
//    returnOnAsset=finviz.getCharacteristic(elements,28,true);
//    returnOnAssetsPercentile=Fidelity.getPercentileElement(percentileElement,120,false);
//    returnOnEquity=finviz.getCharacteristic(elements,34,true);
//    returnOnEquityPercentile=Fidelity.getPercentileElement(percentileElement,111,false);
//    returnOnInvestment=finviz.getCharacteristic(elements,40,true);
//    RevenueGrowthLastQrtrvsSameQrtrPriorYear=Fidelity.getTickerElements(tickerElement,17);
//    RevenueGrowthTtm=Fidelity.getTickerElements(tickerElement,18);
//    salesGrowthLastFiveYears=finviz.getCharacteristic(elements,45,true);
//    salesGrowthQtrOverQtr=finviz.getCharacteristic(elements,51,true);
    
}
