package screener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RoaGreatenThan25List {

    private List<String> tickersList;

    public RoaGreatenThan25List() {
        Document firstScreen = null;
        Document secondScreen = null;
        Document thirdScreen = null;
        Document forthScreen = null;
        Document fifthScreen = null;

        try {
            firstScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4").get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements tickerElementsInFirstTab = firstScreen.select(".screener-link-primary");
        Elements totalTickersElements = firstScreen.select(".count-text[width='140']");

        tickersList = new ArrayList<String>(Arrays.asList(tickerElementsInFirstTab.text().split(" ")));

        // output 'Total: 83 #1'
        String totalTickersText = totalTickersElements.text();

        int indexOfStringToBeRemovedFromBack = totalTickersText.indexOf(" #");

        // 7 for 'Total: '
        String totalTickersInString = totalTickersText.subSequence(7, indexOfStringToBeRemovedFromBack).toString();

        int totalTickers = Integer.parseInt(totalTickersInString);
        System.out.println("total tickers: " + totalTickers);

        if (totalTickers > 20) {
            try {
                secondScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4&r=21").get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements tickerElementsInSecondTab = secondScreen.select(".screener-link-primary");
            List<String> tickersListInSecondTab = new ArrayList<String>(Arrays.asList(tickerElementsInSecondTab.text().split(" ")));
            tickersList.addAll(tickersListInSecondTab);
        }

        if (totalTickers > 40) {
            try {
                thirdScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4&r=41").get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements tickerElementsInThirdTab = thirdScreen.select(".screener-link-primary");
            List<String> tickersListInThirdTab = new ArrayList<String>(Arrays.asList(tickerElementsInThirdTab.text().split(" ")));
            tickersList.addAll(tickersListInThirdTab);
        }

        if (totalTickers > 60) {
            try {
                forthScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4&r=61").get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements tickerElementsInForthTab = forthScreen.select(".screener-link-primary");
            List<String> tickersListInForthTab = new ArrayList<String>(Arrays.asList(tickerElementsInForthTab.text().split(" ")));
            tickersList.addAll(tickersListInForthTab);
        }

        if (totalTickers > 80) {
            try {
                fifthScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4&r=81").get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements tickerElementsInFifthTab = fifthScreen.select(".screener-link-primary");
            List<String> tickersListInFifthTab = new ArrayList<String>(Arrays.asList(tickerElementsInFifthTab.text().split(" ")));
            tickersList.addAll(tickersListInFifthTab);
        }

    }

    public String[] tickers() {

        String[] tickerArray = new String[tickersList.size()];
        return tickerArray = tickersList.toArray(tickerArray);
    }

    public static void main(String[] args) {
        printRoaGreatenThan25List();
    }

    // Print tickers
    private static void printRoaGreatenThan25List() {

        RoaGreatenThan25List highRoaLowPEScreenResult = new RoaGreatenThan25List();
        String[] highRoaLowPEScreenResultTickers = highRoaLowPEScreenResult.tickers();
        System.out.print("{\"");
        for (String string : highRoaLowPEScreenResultTickers) {
            System.out.print(string + "\",\"");
        }

        System.out.print("}");
    }
}
