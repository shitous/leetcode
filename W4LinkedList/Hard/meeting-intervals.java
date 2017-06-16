给一组meetings（每个meeting由start和end时间组成）。求出在所有输入meeting时间段内没有会议，也就是空闲的时间段。每个subarray都已经sort好。N个员工，
每个员工有若干个interval表示在这段时间是忙碌的。求所有员工都不忙的intervals。(这题参考 https://leetcode.com/problems/merge-intervals )
举例： [
   [[1, 3], [6, 7]],
   [[2, 4]],
   [[2, 3], [9, 12]]. 
]
返回 [[4, 6], [7, 9]]

public class solution {
    public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
    }
    public ArrayList<Interval> meetings (Interval[][] intervals) {
	ArrayList<Interval> leftsList = new ArrayList<>();
	ArrayList<Interval> rightsList = new ArrayList<>();
	for (int i = 0; i < intervals.length; i++) {
	    for (int j = 0; j < intervals[0].length; j++) {
		leftsList.add(intervals[i][j]);
		rightsList.add(intervals[i][j]);
	    }
	}
	Interval[] lefts = (Interval[]) leftsList.toArray();
	Interval[] rights = (Interval[]) rightsList.toArray();
		
	Arrays.sort(lefts, (a, b) -> {
		if (a.start != b.start){
		    return Integer.compare(a.start,  b.start);
		} else {
		    return Integer.compare(a.end, b.end);
		}
	    });
	Arrays.sort(rights, (a, b) -> {
		if (a.end != b.end){
		    return Integer.compare(a.end,  b.end);
		} else {
		    return Integer.compare(a.start, b.start);
		}
	    });		

	int leftIndex = 0;
	int rightIndex = 0;
	int curIndex = 0;
	int preIndex = 0;
	HashSet<Interval> set = new HashSet<>();
	ArrayList<Interval> res = new ArrayList<>();
		
	while (rightIndex < rights.length) {
	    if (leftIndex == lefts.length || lefts[leftIndex].start > rights[rightIndex].end) { // >= ?
		curIndex = rights[rightIndex].end;
		set.remove(rights[rightIndex++]);
	    } else {
		curIndex = lefts[leftIndex].start;
		set.add(lefts[leftIndex++]);
	    }
	    if (set.isEmpty()) {
		preIndex = curIndex;
	    }
	    if (set.size() == 1 && preIndex != curIndex) {
		res.add(new Interval(preIndex, curIndex));
	    }
	}
	return res;
    }
}
