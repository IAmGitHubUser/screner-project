package test.pairs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * PairManager
 * 
 * This class ctr takes a filename to a JSON file in the format of:
 * 
 * [  
 *   {  
 *       "start": 49679,
 *       "end": 52015
 *   },
 *   {  
 *		"start": 49800,
 *       "end": 50000 
 *   }
 *  ]
 *  
 * This file will be read and entered into the inputList.
 * The method MergePairs will sort and then merge the pairs.  
 * Each merged pair is added to the resultList.
 * 
 * Note: If the first value is higher than the second value the input is ignored
 * per the requirements.
 * 
 * @author ddaly
 */
public class PairManager {

	final static Logger logger = Logger.getLogger(PairManager.class);
	// holds the parsed integer pairs 
	List<Pair> inputList = new ArrayList<Pair>();
	// holds the result integer pairs
	List<Pair> resultList = new ArrayList<Pair>();
	
	public PairManager(String filename) throws FileNotFoundException, IOException {
		try{
			JSONParser parser = new JSONParser();
			JSONArray valuesArray = (JSONArray) parser.parse(new FileReader(filename));
			for( Object o:valuesArray){
				JSONObject pair = (JSONObject)o;
			    int start = ((Long)pair.get("start")).intValue();
			    int end = ((Long)pair.get("end")).intValue();
			    // insure that the first value is lower or equal to the second value.
			    if( start <= end ){
			    	inputList.add(new Pair(start, end));
			    } else {
			    	logger.debug("Input ignored: " + new Pair(start, end));
			    }
			}
		} catch(ParseException pe){
			logger.debug("JSON Parse exception: " + pe.getMessage());
			throw new RuntimeException("Error parsing JSON file.  Please check the log file.");
		} 
	}
	
	/**
	 * Call this method to first sort and then merge the list of pairs.  
	 * 
	 * Merging methodology:  First, the list is sorted smallest to largest.  "Smallest"
	 * is defined as either the first value is smaller or, if the first values are the same
	 * then the end values are sorted by smallest.  Otherwise the pairs are the same.
	 * 
	 * The list is traversed from the beginning in one pass so the "compare" method
	 * has a big O of N.
	 * 
	 */
	public void mergePairs() {
		logger.debug("Unsorted list: " + inputList);
		// First we sort the list from lowest to highest value.  This allows us to make one pass on the list.
		Collections.sort(inputList);
		logger.debug("Sorted list: " + inputList);
		compare(inputList.get(0), 1);
	}
	
	/**
	 * This method is called recursively.  It takes the temp pair passed in and compares it to the next pair in the list.  
	 * If we are at the end of the list, then this pair is the final pair and will be stored out.
	 * 
	 * @param temp - temporary pair to check against the next pair in the list. 
	 * @param nextIndex - the next index in the sorted list.
	 * 
	 * Note: This method assumes that the list has been sorted.
	 */
	public void compare(Pair tempPair, int nextIndex){
		
		// if we are at the end of the list we are done comparing.  Save the last value.
		if( (nextIndex) >= inputList.size()) {
			logger.debug("Saving pair: " + tempPair);
			resultList.add(tempPair);
			return;
		}
		
		// get the next pair from the list 
		Pair next = inputList.get(nextIndex);
		
		// First check if the next pair intersects with the existing temp pair.  We check this by
		// testing if the temp end value is larger than the start of the next pair.  If it does 
		// then we will need to check if its ending value is also contained in the temp pair - 
		// if not then we will use the new larger value as our end point.
		if( (tempPair.end ) >= next.start) {
			// find the largest ending value
			int end = tempPair.end > next.end ? tempPair.end : next.end;
			// create a new pair to use in the next test.
			Pair t = new Pair(tempPair.start, end); 
			compare(t, nextIndex + 1);
		} else {
			// if the pairs do not intersect, then we have an independent pair so print it out, save it, whatever,
			// then move to the next value in the list and increment the index.
			logger.debug("Saving pair: " + tempPair);
			resultList.add(tempPair);
			compare(inputList.get(nextIndex), nextIndex + 1);
		}
	}
	
	public List<Pair> getResult() {
		return resultList;
	}
}
