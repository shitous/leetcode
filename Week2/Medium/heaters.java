public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int dis = 0;
	// for each house, find the closest heaters, record the distance, and find the max distance.
        for (int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if (index<0) index = -(index+1);
            int left = index>0?house - heaters[index-1]: Integer.MAX_VALUE;
            int right = index<heaters.length?heaters[index]-house: Integer.MAX_VALUE;
            dis = Math.max(dis, Math.min(left,right));
        }
        return dis;
    }
}
