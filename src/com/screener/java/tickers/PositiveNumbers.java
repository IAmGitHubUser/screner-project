package com.screener.java.tickers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PositiveNumbers {

    private List<String> tickersList;

    public PositiveNumbers() {
        Document firstScreen = null;
        Document secondScreen = null;
        Document thirdScreen = null;
        Document forthScreen = null;
        Document fifthScreen = null;

        try {
            firstScreen = Jsoup
                    .connect("https://finviz.com/screener.ashx?v=111&f=fa_eps5years_pos,fa_epsqoq_pos,fa_epsyoy_pos,fa_grossmargin_pos,fa_netmargin_pos,fa_opermargin_pos,fa_pe_profitable,fa_roa_pos,fa_roe_pos,fa_roi_pos,fa_sales5years_pos,fa_salesqoq_pos,sh_price_o10&ft=4")
//                    .connect("https://finviz.com/screener.ashx?v=111&f=fa_curratio_o1,fa_debteq_u1,fa_eps5years_pos,fa_epsqoq_pos,fa_epsyoy_pos,fa_grossmargin_pos,fa_ltdebteq_u1,fa_netmargin_pos,fa_opermargin_pos,fa_pe_profitable,fa_roa_pos,fa_roe_pos,fa_roi_pos,fa_sales5years_pos,fa_salesqoq_pos,sh_price_o10&ft=4")
                    .get();

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

        double totalTabsDouble = totalTickers / 20.0;

        double totalTabRoundUpDouble = Math.ceil(totalTabsDouble);

        int totalTabRoundUpInt = (int) totalTabRoundUpDouble;
        System.out.println("totalTabRoundUpInt " + totalTabRoundUpInt);

        // For second tab its 21, for 3rd it 41 and so on
        int lastTwoCharactersInLink = 21;

        // Start with second tab
        // Go till last tab
        for (int tabNumber = 2; tabNumber <= totalTabRoundUpInt; tabNumber++) {

            try {
                secondScreen = Jsoup
                        .connect("https://finviz.com/screener.ashx?v=111&f=fa_eps5years_pos,fa_epsqoq_pos,fa_epsyoy_pos,fa_grossmargin_pos,fa_netmargin_pos,fa_opermargin_pos,fa_pe_profitable,fa_roa_pos,fa_roe_pos,fa_roi_pos,fa_sales5years_pos,fa_salesqoq_pos,sh_price_o10&ft=4&r="
                                + lastTwoCharactersInLink)
                        .get();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements tickerElementsInSecondTab = secondScreen.select(".screener-link-primary");
            List<String> tickersListInSecondTab = new ArrayList<String>(Arrays.asList(tickerElementsInSecondTab.text().split(" ")));
            tickersList.addAll(tickersListInSecondTab);

            // Increase number by 20 to go to next tab
            lastTwoCharactersInLink = lastTwoCharactersInLink + 20;
        }

    }

    public String[] tickers() {

        String[] tickerArray = new String[tickersList.size()];
        return tickerArray = tickersList.toArray(tickerArray);
    }

    public static void main(String[] args) {
        printPositiveComapniesList();
    }

    // Print tickers
    private static void printPositiveComapniesList() {

        PositiveNumbers highRoaLowPEScreenResult = new PositiveNumbers();
        String[] highRoaLowPEScreenResultTickers = highRoaLowPEScreenResult.tickers();
        System.out.print("{\"");
        for (String string : highRoaLowPEScreenResultTickers) {
            System.out.print(string + "\",\"");
        }

        System.out.print("}");
    }
}
