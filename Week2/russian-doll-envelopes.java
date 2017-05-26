public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // transfer into longest increasing subsequence
        if( envelopes== null || envelopes.length==0||envelopes[0]==null||envelopes[0].length!=2) return 0;
        Arrays.sort(envelopes, new Comparator<int []> (){
           public int compare (int[] arr1, int [] arr2){
               if(arr1[0]== arr2[0]) return arr2[1] - arr1[1];
               else return arr1[0]-arr2[0];
           } 
        });
        int [] tails = new int [envelopes.length];
        int len =0;
        // longest increasing subsequene
        for (int [] envelope : envelopes){
            int index = Arrays.binarySearch(tails, 0, len, envelope[1]);
            if (index < 0) index = -(index+1);
            tails[index]=envelope[1];
            if(index ==len) len++;
        }
        return len;
    }
}
