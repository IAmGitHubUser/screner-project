package com.screener.sector;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Reads sector info from fidelity.
 * 
 * @author hpatel
 *
 */
public class SectorFromFidelity {
    /**
     * Constructor.
     * 
     */
    public SectorFromFidelity() {
        Document firstScreen = null;

        String urlPrefix = "https://fundresearch.fidelity.com/mutual-funds/composition/";
        String fundNumber = "922908306";
        String urlPostfix = "?type=sq-NavBar";
        String url = urlPrefix + fundNumber + urlPostfix;
        System.out.println(url);
        try {
            firstScreen = Jsoup
                    .connect(url)
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
