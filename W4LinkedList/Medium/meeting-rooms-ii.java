/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *  1 - 3
 *      3 - 6
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            left[i] = intervals[i].start;
            right[i] = intervals[i].end;
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int res = 0, cur = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        
        while (rightIndex < intervals.length) {
            if (leftIndex == intervals.length || left[leftIndex] >= right[rightIndex]) { // >= ?
                rightIndex++;
                cur--;
            }
            else {
                leftIndex++;
                cur++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
