package test.pairs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
 
public class Test {
 
	public static void main(String[] args) throws FileNotFoundException, IOException {
		PairManager manager = new PairManager("c:\\temp\\values1.json");
		manager.mergePairs();
		List<Pair> resultList = manager.getResult();
		System.out.println(resultList);	
	}
            
}
