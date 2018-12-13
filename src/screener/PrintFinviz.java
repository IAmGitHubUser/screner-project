package screener;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PrintFinviz {

    Finviz finvizScreener = new Finviz();

    public void printFinvizValue(Elements elements) {

        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        String[] values = {formatDateTime, finvizScreener.getCharacteristic(elements, 66, false), finvizScreener.getCharacteristic(elements, 7, true),
                           finvizScreener.getCharacteristic(elements, 26, false), finvizScreener.getCharacteristic(elements, 39, true),
                           finvizScreener.getCharacteristic(elements, 43, true), finvizScreener.getCharacteristic(elements, 58, true),
                           finvizScreener.getCharacteristic(elements, 2, false), finvizScreener.getCharacteristic(elements, 28, true),
                           finvizScreener.getCharacteristic(elements, 62, false), finvizScreener.getCharacteristic(elements, 45, true),
                           finvizScreener.getCharacteristic(elements, 34, true), finvizScreener.getCharacteristic(elements, 56, false),
                           finvizScreener.getCharacteristic(elements, 21, true), finvizScreener.getCharacteristic(elements, 57, true),
                           finvizScreener.getCharacteristic(elements, 40, true), finvizScreener.getCharacteristic(elements, 46, true),
                           finvizScreener.getCharacteristic(elements, 51, true), finvizScreener.getCharacteristic(elements, 50, false)};
        for (String string : values) {
            System.out.print(string + " ");
        }

    }

    public void getPeg(Elements elements) {

        String[] values = {finvizScreener.getCharacteristic(elements, 14, false)};
        for (String string : values) {
            System.out.print(string + " ");
        }

    }

    public void printPeg(String tickerSymbol) {
        Document doc = null;

        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements bChildrerOfTd = doc.select("td > b");
//        System.out.println(bChildrerOfTd);

        System.out.print(tickerSymbol + " ");
        // print.printFinvizValue(bChildrerOfTd);
        getPeg(bChildrerOfTd);
        System.out.println();

    }

    public void printFinvizScreen(String tickerSymbol) {
        Document doc = null;

        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements bChildrerOfTd = doc.select("td > b");

        // To print all the values
        // System.out.println(bChildrerOfTd);

        System.out.print(tickerSymbol + " ");
        // print.printFinvizValue(bChildrerOfTd);
        printFinvizValue(bChildrerOfTd);
//        System.out.println();

    }

}
