public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int point1 = 0;
        int point2 = 0;
        List<Integer> list = new ArrayList<>();
        while(point1 < nums1.length && point2 < nums2.length){
            if(nums1[point1]< nums2[point2]) point1++;
            else if (nums2[point2] < nums1[point1]) point2++;
            else{
                if(nums1[point1]==nums2[point2]) list.add(nums1[point1]);
                point1++;
                point2++;
            }
        }
        int [] res = new int [list.size()];
        int i =0;
        for (int num : list){
            res[i++]=num;
        }
        return res;
        
        
    }
}
