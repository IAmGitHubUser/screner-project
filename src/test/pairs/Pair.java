package test.pairs;

/**
 * Pair
 * 
 * This class defines a pair of integer values where the start value 
 * is always less then or equal to the end value.
 * 
 * @author ddaly
 */
public class Pair implements Comparable<Pair> {
	int start;
	int end;
	
	public Pair(){}
	public Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * If the start values are not equal, then return the current start value minus the passed 
	 * start value.
	 * 
	 * if the start values are equal, return the current end value minus the passed
	 * end value.
	 * 
	 */
	@Override
	public int compareTo(Pair o) {
		if( start != o.start)
			return start - o.start;
		else
			return end - o.end;
	}
	
	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Pair.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Pair p = (Pair)obj;
	    if(this.start == p.start && this.end == p.end){
	    	return true;
	    }else{
	    	return false;
	    }
	}
};