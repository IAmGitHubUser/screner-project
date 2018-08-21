package com.screener.java.copy;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Finviz {

    private final Map<String, Map<String, String>> maps = new HashMap<>();

    private static final String[] TICKERS = {"BPT", "EBAY", "EQM", "GILD", "NTES", "PVAC", "GLW", "BWEN", "YRD"};

    public Finviz() {
        for (String ticker : TICKERS) {

        }
    }

    // public String

    public String getCharacteristic(Elements elements, int index, boolean b) {
        Element elementAtIndex = elements.get(index - 1);
        String characteristicWithUnit = elementAtIndex.text();
        String characteristic = null;
        if (characteristicWithUnit.length() == 1) {
            characteristic = characteristicWithUnit;
        } else {

            // Remove last character (character B)
            int removeOneChara;
            if (b == true) {
                removeOneChara = 1;
            } else {
                removeOneChara = 0;
            }

            characteristic = characteristicWithUnit.substring(0, characteristicWithUnit.length() - removeOneChara);
        }
        return characteristic;
    }

}
