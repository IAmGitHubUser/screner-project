package screener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ScreenResult {

    public void sortedQuotes(Map<String, Double> minPercentileAndQuote, Boolean descendingOrder, Boolean value) {
        System.out.println("***********************");
        System.out.println("Screened ones in order:");
        System.out.println("***********************");
        Set<Entry<String, Double>> set = minPercentileAndQuote.entrySet();
        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {

                // Descending order
                if (descendingOrder) {
                    return (o2.getValue()).compareTo(o1.getValue());
                } else {
                    // Ascending order
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            }
        });
        for (Map.Entry<String, Double> entry : list) {
            if (value) {
                System.out.println(entry.getKey() + " ==== " + entry.getValue());
            } else {
                System.out.println(entry.getKey());
            }
        }
    }
}
