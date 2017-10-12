package test.pairs;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import test.pairs.Pair;
import test.pairs.PairManager;


public class PairTest {

	@Test
	public void TestValues1() throws FileNotFoundException, IOException {
		PairManager manager = new PairManager("/Users/hpatel/Downloads/pairProblem/values1.json");
		manager.mergePairs();
		List<Pair> resultList = manager.getResult();
	    assertTrue(resultList.contains(new Pair(43012, 47900)));
	    assertTrue(resultList.contains(new Pair(49679, 53479)));
	    assertTrue(resultList.contains(new Pair(54012, 59607)));
	}
	
	@Test
	public void TestValues2() throws FileNotFoundException, IOException {
		PairManager manager = new PairManager("/Users/hpatel/Downloads/pairProblem/values2.json");
		manager.mergePairs();
		List<Pair> resultList = manager.getResult();
	    assertTrue(resultList.contains(new Pair(94133, 94133)));
	    assertTrue(resultList.contains(new Pair(94200, 94299)));
	    assertTrue(resultList.contains(new Pair(94600, 94699)));
	}
	
	@Test
	public void TestValues3() throws FileNotFoundException, IOException {
		PairManager manager = new PairManager("/Users/hpatel/Downloads/pairProblem/values3.json");
		manager.mergePairs();
		List<Pair> resultList = manager.getResult();
	    assertTrue(resultList.contains(new Pair(94133, 94133)));
	    assertTrue(resultList.contains(new Pair(94200, 94399)));
	}

}
