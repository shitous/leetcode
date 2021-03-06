
 Given two lists of intervals, find their overlapping intervals, e.g.
    l1: [1,5], [7,10], [12,18], [22,24]
    l2: [3,8], [13,15], [16,17], [18,21], [22,23]
    returns [3,5],[7,8],[13,15],[16,17],[18,18],[22,23] 

public class solusion {
    
    public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
    }
	
    public ArrayList<Interval> overlappingIntervals(Interval[] l1, Interval[] l2){
	Arrays.sort(l1, (a, b) -> {
		if (a.start != b.start) {
		    return Integer.compare(a.start, b.start);
		} else {
		    return Integer.compare(a.end, b.end);
		}
			
	    });
	Arrays.sort(l2, (a, b) -> {
		if (a.start != b.start) {
		    return Integer.compare(a.start, b.start);
		} else {
		    return Integer.compare(a.end, b.end);
		}
			
	    });
		
	int l1Index = 0;
	int l2Index = 0;
	ArrayList<Interval> res = new ArrayList<>();
	while (l1Index < l1.length && l2Index < l2.length) {			
	    int start = Math.max(l1[l1Index].start, l2[l2Index].start);
	    int end = Math.min(l1[l1Index].end, l2[l2Index].end);
	    if (start <= end) {
		res.add(new Interval(start, end));
	    }
			
	    if (l1[l1Index].end < l2[l2Index].end) {
		l1Index++;
	    } else if (l1[l1Index].end > l2[l2Index].end) {
		l2Index++;
	    } else {
		l1Index++;
		l2Index++;
	    }
	}
		
	return res;
    }
}
